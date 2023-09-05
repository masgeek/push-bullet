package com.masgeek.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class ApiClient(val baseUrl: String, val headers: Map<String, String> = emptyMap()) {
    private val objectMapper: ObjectMapper = jacksonObjectMapper()

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val originalRequest = chain.request()
            val builder = originalRequest.newBuilder()
            for ((key, value) in headers) {
                builder.addHeader(key, value)
            }
            val newRequest = builder.build()
            chain.proceed(newRequest)
        }.build()

    private val retrofit =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(JacksonConverterFactory.create(objectMapper)).build()

    val pushBulletService: PushBulletService = retrofit.create(PushBulletService::class.java)


}
