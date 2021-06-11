package com.chandra.suitmediatest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Guest (
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("birthdate")
    val birthdate: String = "",

    var image: Int=0
)