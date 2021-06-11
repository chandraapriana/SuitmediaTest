package com.chandra.suitmediatest.data

import com.chandra.suitmediatest.R
import com.chandra.suitmediatest.data.model.Guest
import com.chandra.suitmediatest.data.remote.RemoteDataSource
import com.chandra.suitmediatest.utils.DataDummy.listImage

class Repository(private val remoteDataSource: RemoteDataSource) {
    suspend fun getGuest(): List<Guest> {
        val listGuest = remoteDataSource.getGuest()
        for (i in listGuest!!.indices){
            listGuest[i].image = listImage()[i]
        }
        return listGuest
    }
}