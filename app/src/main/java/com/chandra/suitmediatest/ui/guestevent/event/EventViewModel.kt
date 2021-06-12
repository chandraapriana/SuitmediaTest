package com.chandra.suitmediatest.ui.guestevent.event

import androidx.lifecycle.ViewModel
import com.chandra.suitmediatest.utils.DataDummy

class EventViewModel:ViewModel() {
    fun getDummyEvent() = DataDummy.generateDummyEvent()
}