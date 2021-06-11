package com.chandra.suitmediatest.ui.guestevent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuestEventViewModel : ViewModel() {
    private var _name: MutableLiveData<String> = MutableLiveData()
    private var _nameGuest: MutableLiveData<String> = MutableLiveData()
    var name: LiveData<String> = _name
    var nameGuest: LiveData<String> = _nameGuest

    fun setName(name: String) {
        this._name.value = name
    }

    fun setNameGuest(nameGuest: String) {
        this._nameGuest.value = nameGuest
    }


}