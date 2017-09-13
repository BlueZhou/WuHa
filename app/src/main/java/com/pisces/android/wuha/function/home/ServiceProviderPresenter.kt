package com.pisces.android.wuha.function.home

import android.content.Context
import com.pisces.android.wuha.Config
import com.pisces.android.wuha.entity.BodyForServiceByCount
import com.pisces.android.wuha.entity.BodyForServiceByDistance
import com.pisces.android.wuha.entity.BodyForServiceByPrice
import com.pisces.android.wuha.entity.bean.ServiceProvider
import com.pisces.android.wuha.net.HttpUtli
import com.pisces.android.wuha.net.api.Api
import com.pisces.android.wuha.net.subscriber.SimpleSubscriber
import com.yingwumeijia.commonlibrary.utils.ListUtil

/**
 * Created by Chris Li on 2017/9/13.
 */
class ServiceProviderPresenter(val view: BaseServiceProviderContract.View, val context: Context) : BaseServiceProviderContract.Presenter {
    override fun loadDataForBodyByDistance(bodyForServiceByDistance: BodyForServiceByDistance) {
        HttpUtli.toSubscribe(Api.service.getServiceFromLocation(bodyForServiceByDistance), object : SimpleSubscriber<ArrayList<ServiceProvider>>(context) {
            override fun onSuccess(t: ArrayList<ServiceProvider>?) {
                if (t == null) return Unit
                view.showEmpty(bodyForServiceByDistance.CurrentPageIndex == Config.page && ListUtil.isEmpty(t))
                view.onLoadCompleted(bodyForServiceByDistance.CurrentPageIndex, ListUtil.isEmpty(t))
                if (!ListUtil.isEmpty(t))
                    view.onResponse(t)
            }

        })
    }

    override fun loadDataForBodyByPrice(bodyForServiceByPrice: BodyForServiceByPrice) {
        HttpUtli.toSubscribe(Api.service.getServiceFromPrice(bodyForServiceByPrice), object : SimpleSubscriber<ArrayList<ServiceProvider>>(context) {
            override fun onSuccess(t: ArrayList<ServiceProvider>?) {
                if (t == null) return Unit
                view.showEmpty(bodyForServiceByPrice.CurrentPageIndex == Config.page && ListUtil.isEmpty(t))
                view.onLoadCompleted(bodyForServiceByPrice.CurrentPageIndex, ListUtil.isEmpty(t))
                if (!ListUtil.isEmpty(t))
                    view.onResponse(t)
            }

        })
    }

    override fun loadDataForBodyByCount(bodyForServiceByCount: BodyForServiceByCount) {
        HttpUtli.toSubscribe(Api.service.getServiceFromCount(bodyForServiceByCount)
                , object : SimpleSubscriber<ArrayList<ServiceProvider>>(context) {
            override fun onSuccess(t: ArrayList<ServiceProvider>?) {
                if (t == null) return Unit
                view.showEmpty(bodyForServiceByCount.CurrentPageIndex == Config.page && ListUtil.isEmpty(t))
                view.onLoadCompleted(bodyForServiceByCount.CurrentPageIndex, ListUtil.isEmpty(t))
                if (!ListUtil.isEmpty(t))
                    view.onResponse(t)
            }

        })
    }

}