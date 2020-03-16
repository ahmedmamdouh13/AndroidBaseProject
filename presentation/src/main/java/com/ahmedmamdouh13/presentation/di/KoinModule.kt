package com.ahmedmamdouh13.presentation.di

import com.ahmedmamdouh13.data.remote.RemoteService
import com.ahmedmamdouh13.data.RepositoryImpl
import com.ahmedmamdouh13.data.mapper.PostsMapper
import com.ahmedmamdouh13.domain.Repository
import com.ahmedmamdouh13.domain.abstraction.GetPostsInteractor
import com.ahmedmamdouh13.domain.usecase.GetPostsUseCase
import com.ahmedmamdouh13.presentation.mapper.PostMapper
import com.ahmedmamdouh13.presentation.viewmodel.MainViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val module = module {


    single<RemoteService> {
        Retrofit.Builder()
            .baseUrl("https://www.reddit.com")
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient())
            .build().create(RemoteService::class.java)
    }


    single<Repository> {
        RepositoryImpl(get(), get())
    }
    single<GetPostsInteractor>() {
        GetPostsUseCase(get())
    }
    single<PostMapper> {
        PostMapper()
    }
    single<PostsMapper> {
        PostsMapper()
    }

    single<MainViewModel> {
        MainViewModel(get(), get())
    }


}