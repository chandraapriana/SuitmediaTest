package com.chandra.suitmediatest.data.remote

import com.chandra.suitmediatest.data.model.Guest
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("596dec7f0f000023032b8017")
    suspend fun getGuest():Response<List<Guest>>

}