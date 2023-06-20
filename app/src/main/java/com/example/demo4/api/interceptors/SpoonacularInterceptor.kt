package com.example.demo4.api.interceptors

import com.example.demo4.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class SpoonacularInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = BuildConfig.SPOONACULAR_API_KEY
        val url = chain.request().url.newBuilder().addQueryParameter("apiKey",apiKey).build()
        val newRequest = chain.request()
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(newRequest)
    }

}