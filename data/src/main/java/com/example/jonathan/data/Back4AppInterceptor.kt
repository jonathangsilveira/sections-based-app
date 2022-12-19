package com.example.jonathan.data

import okhttp3.Interceptor
import okhttp3.Response

private const val KEY = "{API_KEY}"
private const val APP_ID = "{APPLICATION_ID}"
private const val APPLICATION_ID_HEADER = "X-Parse-Application-Id"
private const val REST_API_KEY_HEADER = "X-Parse-REST-API-Key"

class Back4AppInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader(APPLICATION_ID_HEADER, APP_ID)
            .addHeader(REST_API_KEY_HEADER, KEY)
            .build()
        return chain.proceed(request)
    }
}