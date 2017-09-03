package com.pisces.android.wuha.net.subscriber

import android.app.ProgressDialog
import android.content.Context
import com.pisces.android.wuha.net.HttpUtli
import com.pisces.android.wuha.widget.WuHaProgressDialog
import rx.Subscriber

/**
 * Created by Jam on 2017/9/2.
 */
abstract class ProgressSubscriber<T>(val context: Context) : Subscriber<T>() {

    val progress by lazy { WuHaProgressDialog(context) }

    abstract fun onSuccess(t: T?)

    /**
     * @param e 异常
     *
     * @return 是否自己实现异常处理 ， 默认返回false交由系统处理
     */
    fun onFail(e: Throwable?): Boolean {
        return false
    }

    override fun onNext(t: T?) {
        onSuccess(t)
    }

    override fun onCompleted() {
        progress.dismiss()
    }

    override fun onError(e: Throwable?) {
        if (!onFail(e))
            HttpUtli.disposeHttpException(context, e)
        progress.dismiss()
    }

}