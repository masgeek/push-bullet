package com.masgeek.api

import com.masgeek.api.dto.PushMessage
import com.masgeek.api.dto.PushBulletUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface PushBulletService {
    @GET("v2/user/me")
    fun getCurrentUser(): Call<PushBulletUser>

    @POST("v2/pushes")
    fun sendPush(): Call<PushMessage>
}
