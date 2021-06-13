package com.chandra.suitmediatest.ui.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.chandra.suitmediatest.data.Repository
import com.chandra.suitmediatest.data.remote.ApiInterface
import com.chandra.suitmediatest.data.remote.RemoteDataSource
import com.chandra.suitmediatest.ui.event.EventViewModel
import com.chandra.suitmediatest.ui.eventmap.EventMapViewModel
import com.chandra.suitmediatest.ui.guest.GuestViewModel
import com.chandra.suitmediatest.ui.guestevent.GuestEventViewModel
import com.chandra.suitmediatest.utils.BASE_URL
import com.chandra.suitmediatest.utils.InternetConnection
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

@RequiresApi(Build.VERSION_CODES.M)
val appModule = module {

    single {
        Cache(
            File(androidContext().cacheDir, "http_cache"),
            50L * 1024L * 1024L
        )
    }


    single {
        OkHttpClient.Builder().cache(get()).addInterceptor {
            val request: Request = if (InternetConnection.isOnline(androidContext())) {
                it.request()
            } else {
                it.request().newBuilder()
                    .header("Cache-Control", "max-stale=${50L * 1024L * 1024L}").build()
            }
            it.proceed(request)
        }.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create(ApiInterface::class.java)
    }

    single {
        RemoteDataSource(get())
    }

    single {
        Repository(get())
    }

    viewModel {
        GuestViewModel(get())
    }

    viewModel {
        GuestEventViewModel()
    }

    viewModel {
        EventViewModel()
    }

    viewModel {
        EventMapViewModel()
    }

}