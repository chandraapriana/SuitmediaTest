package com.chandra.suitmediatest.ui.guestevent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuestEventViewModel : ViewModel() {
    private var _name: MutableLiveData<String> = MutableLiveData()
    private var _nameGuest: MutableLiveData<String> = MutableLiveData()
    private var _nameEvent: MutableLiveData<String> = MutableLiveData()
    private var _date: MutableLiveData<String>? = MutableLiveData()


    var name: LiveData<String> = _name
    var nameGuest: LiveData<String> = _nameGuest
    var nameEvent: LiveData<String> = _nameEvent
    var date: LiveData<String>? = _date

    fun setName(name: String) {
        this._name.postValue(name)
    }

    fun setNameGuest(nameGuest: String) {
        this._nameGuest.postValue(nameGuest)
    }

    fun setNameEvent(nameEvent:String){
        this._nameEvent.postValue(nameEvent)
    }

    fun setDate(date: String?){
        this._date?.postValue(date)
    }

}