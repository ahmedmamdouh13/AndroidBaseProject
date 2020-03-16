package com.ahmedmamdouh13.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface RemoteService {

    @GET("/r/androiddev/.json")
    suspend fun getAndroidDevPosts(): Response<RedditResponse>

}