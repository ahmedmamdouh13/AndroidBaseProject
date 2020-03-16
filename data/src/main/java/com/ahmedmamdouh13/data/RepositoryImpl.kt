package com.ahmedmamdouh13.data

import com.ahmedmamdouh13.data.mapper.PostsMapper
import com.ahmedmamdouh13.data.remote.RemoteService
import com.ahmedmamdouh13.domain.Repository
import com.ahmedmamdouh13.domain.Result

class RepositoryImpl(
    private val remoteService: RemoteService,
    private val postsMapper: PostsMapper
) : Repository {

    override suspend fun requestNetworkPosts(): Result {
        return try {
            val androidDevPosts = remoteService.getAndroidDevPosts()
            val data = postsMapper.mapFromResonseToDomain(androidDevPosts.body()!!)
            Result.Success(data = data!!)
        } catch (e: Exception) {
            Result.Error(e = e)
        }
    }
}