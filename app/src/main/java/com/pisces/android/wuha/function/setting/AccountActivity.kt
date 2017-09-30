package com.pisces.android.wuha.function.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.UserHandle
import android.support.v4.app.ActivityCompat
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.muzhi.camerasdk.model.CameraSdkParameterInfo
import com.pisces.android.wuha.Constant
import com.pisces.android.wuha.R
import com.pisces.android.wuha.base.LBaseActivity
import com.pisces.android.wuha.function.setting.bean.BodyPhoto
import com.pisces.android.wuha.function.setting.bean.BodyUserName
import com.pisces.android.wuha.function.upload.UploadPictureHelper
import com.pisces.android.wuha.function.user.UserController
import com.pisces.android.wuha.net.HttpUtli
import com.pisces.android.wuha.net.api.Api
import com.pisces.android.wuha.net.subscriber.ProgressSubscriber
import com.pisces.android.wuha.net.subscriber.SimpleSubscriber
import com.squareup.picasso.Picasso
import com.yingwumeijia.baseywmj.utils.VerifyUtils
import com.yingwumeijia.commonlibrary.utils.ListUtil
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import rx.Observable
import rx.functions.Func2
import java.io.File

/**
 * Created by Chris Li on 2017/9/3.
 * 个人账户界面
 */
class AccountActivity : LBaseActivity() {

    val mCameraSdkParameterInfo by lazy { CameraSdkParameterInfo() }

    val request_code_portrait = CameraSdkParameterInfo.TAKE_PICTURE_FROM_GALLERY

    val userName by lazy { intent.getStringExtra(Constant.KEY_CURRENT) }

    val portraitUrl by lazy { intent.getStringExtra(Constant.KEY_CURRENT2) }

    var portraitChanged = false

    var userNameChanged = false

    var portraitFilePath: String? = null

    companion object {
        fun start(context: Context, username: String, portraitUrl: String) {
            val intent = Intent(context, AccountActivity::class.java)
            intent.putExtra(Constant.KEY_CURRENT, username)
            intent.putExtra(Constant.KEY_CURRENT2, portraitUrl)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        topTitle.text = "账户"
        et_user_name.setText(userName)
        et_user_name.setSelection(userName.length)
        Picasso.with(this).load(portraitUrl).into(user_img)

        topLeft.setOnClickListener { close() }
        user.setOnClickListener { editPortrait() }
        et_user_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                userNameChanged = true
                user_name_delete.visibility = if (usernameValue().isNotEmpty()) View.VISIBLE else View.GONE
            }
        })

        user_name_delete.setOnClickListener { et_user_name.setText("") }
        /*点击上传*/
        account_btn.setOnClickListener {
            if (!verifyUserName(usernameValue())) return@setOnClickListener
            if (portraitChanged) modifyPortraitAndUserName() else modifyUsername()
        }
    }


    /**
     * edit portrait
     */
    private fun editPortrait() {
        mCameraSdkParameterInfo.isFilter_image = false
        mCameraSdkParameterInfo.isShow_camera = true
        mCameraSdkParameterInfo.isSingle_mode = true
        mCameraSdkParameterInfo.isCroper_image = true
        val intent = Intent()
        intent.setClassName(application, "com.muzhi.camerasdk.PhotoPickActivity")
        val b = Bundle()
        b.putSerializable(CameraSdkParameterInfo.EXTRA_PARAMETER, mCameraSdkParameterInfo)
        intent.putExtras(b)
        ActivityCompat.startActivityForResult(this, intent, CameraSdkParameterInfo.TAKE_PICTURE_FROM_GALLERY, null)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data == null) return
        when (requestCode) {
            request_code_portrait -> getBundleForPortrait(data.extras)
        }
    }


    private fun getBundleForPortrait(b: Bundle?) {
        if (b != null) {
            val mCameraSdkParameterInfo = b.getSerializable(CameraSdkParameterInfo.EXTRA_PARAMETER) as CameraSdkParameterInfo
            val list = mCameraSdkParameterInfo.image_list
            if (ListUtil.isEmpty(list)) return Unit
            upLoadPortrait(list[0])
        }
    }

    private fun upLoadPortrait(s: String) {
        Log.d("IMAGE", s)
        portraitChanged = true
        portraitFilePath = s
        Picasso.with(this).load(File(s)).into(user_img)

    }


    private fun usernameValue(): String {
        return et_user_name.text.toString()
    }

    private fun verifyUserName(username: String?): Boolean {
        if (!VerifyUtils.verifyUsername(username)) {
            toastWith("请输入正确的用户名")
            return false
        }
        return true
    }


    private fun modifyPortraitAndUserName() {
        UploadPictureHelper.uploadSinglePicture(this, portraitFilePath!!, object : UploadPictureHelper.OnSingleLoadListener {
            override fun success(url: String) {

                val userId = UserController.getUserInfoBean(this@AccountActivity)!!.id

                val obPortrait = Api.service.modifyUserInfoByPhoto(BodyPhoto(userId, url))
                val obUsername = Api.service.modifyUserInfoByNickName(BodyUserName(userId, usernameValue()))

                val out = Observable.zip(obPortrait, obUsername, object : Func2<Any, Any, Boolean> {
                    override fun call(t1: Any?, t2: Any?): Boolean {
                        return true
                    }

                })

                HttpUtli.toSubscribe(out, object : ProgressSubscriber<Boolean>(this@AccountActivity) {
                    override fun onSuccess(t: Boolean?) {
                        didModifySuccess()
                    }

                })
            }
        })
    }


    private fun modifyUsername() {
        val userId = UserController.getUserInfoBean(this@AccountActivity)!!.id
        val obUsername = Api.service.modifyUserInfoByNickName(BodyUserName(userId, usernameValue()))
        HttpUtli.toSubscribe(obUsername, object : ProgressSubscriber<Any>(this) {
            override fun onSuccess(t: Any?) {
                didModifySuccess()
            }
        })
    }

    private fun didModifySuccess() {
        toastWith("修改成功")
        close()
    }

}