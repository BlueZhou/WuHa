package com.pisces.android.wuha.net.api

import com.pisces.android.wuha.main.MainActivity
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by Jam on 2017/9/2.
 */
interface ApiService {

    @POST("ServiceProvider/GetServiceProviderByDistance")
    fun test(@Body test:MainActivity.Test):Observable<ResponseBody>

}