package com.pisces.android.wuha.function.mine.logged

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pisces.android.wuha.R
import com.pisces.android.wuha.function.mine.BaseMineContentFragment
import com.pisces.android.wuha.function.setting.AccountActivity
import com.pisces.android.wuha.function.user.UserController
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.mine_logged_layout.*
import rx.functions.Action1
import java.io.File

/**
 * Created by Jam on 2017/9/16.
 */
class LoggedFragment : BaseMineContentFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.mine_logged_layout, container, false)
    }

    private var userName: String? = null

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame_menus.removeAllViews()

        if (menusView.parent != null) {
            val parent = menusView.parent as ViewGroup
            parent.removeAllViews()
        }
        frame_menus.addView(menusView)

        ivPortrait.setOnClickListener { AccountActivity.start(context, userName) }

        UserController.getUserInfo(context, Action1 { t ->
            userName = t.name
            if (!TextUtils.isEmpty(t.photoPath))
                Picasso.with(context).load(File( t.photoPath)).into(ivPortrait)
//            LImg.with(this).load(t.photoPath).into(ivPortrait)
            tv_username.text = t.name
        })
    }
}