package com.chandra.suitmediatest.data.remote

class RemoteDataSource(private val apiInterface: ApiInterface) {
    suspend fun getGuest() = apiInterface.getGuest().body()
}