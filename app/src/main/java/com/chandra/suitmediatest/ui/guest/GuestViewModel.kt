package com.chandra.suitmediatest.ui.guest

import androidx.lifecycle.ViewModel
import com.chandra.suitmediatest.data.Repository

class GuestViewModel(private val repository: Repository): ViewModel() {
    suspend fun getGuest() = repository.getGuest()
}