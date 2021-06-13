package com.chandra.suitmediatest.ui.eventmap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventMapViewModel: ViewModel() {
    val _position:MutableLiveData<Int> = MutableLiveData()
    val position:LiveData<Int>  = _position

    fun setPosition(position:Int){
        this._position.postValue(position)
    }
}