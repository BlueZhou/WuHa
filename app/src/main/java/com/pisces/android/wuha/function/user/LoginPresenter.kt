package com.pisces.android.wuha.function.user

import android.content.Context
import android.os.Build
import cn.smssdk.SMSSDK
import com.pisces.android.framworkerlibrary.utlis.Installation
import com.pisces.android.wuha.entity.bean.LoginResponse
import com.pisces.android.wuha.net.HttpUtli
import com.pisces.android.wuha.net.api.Api
import com.pisces.android.wuha.net.subscriber.ProgressSubscriber
import com.yingwumeijia.commonlibrary.utils.AppInfo
import rx.functions.Action1

/**
 * Created by Jam on 2017/9/14.
 */
class LoginPresenter(val context: Context, val view: LoginContract.View) : LoginContract.Presenter {


    override fun login(phone: String) {
        val bodyForLogin = BodyForLogin()
        bodyForLogin.deviceName = Build.DEVICE
        bodyForLogin.currentDeviceIdentificationNumber = Installation.id(context)
        bodyForLogin.mobliePhoneNumber = phone

        UserControler.login(context, bodyForLogin, Action1<LoginResponse> {
            view.loginSuccess()
        })
    }

    override fun sendSmsCode(phone: String) {
        SMSSDK.getVerificationCode("86", phone)
        view.lockSendButton(true)
        view.setTextWithSendButton("60s")
    }


}