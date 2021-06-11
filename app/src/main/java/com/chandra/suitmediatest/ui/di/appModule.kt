package com.chandra.suitmediatest.ui.di

import com.chandra.suitmediatest.data.Repository
import com.chandra.suitmediatest.data.remote.ApiClient
import com.chandra.suitmediatest.data.remote.RemoteDataSource
import com.chandra.suitmediatest.ui.guestevent.GuestEventViewModel
import com.chandra.suitmediatest.ui.guestevent.guest.GuestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        ApiClient.retrofit
    }

    single {
        RemoteDataSource(get())
    }

    single {
        Repository(get() )
    }

    viewModel {
        GuestViewModel(get())
    }

    viewModel {
        GuestEventViewModel()
    }

}