package com.ahmedmamdouh13.data

import com.ahmedmamdouh13.data.mapper.PostsMapper
import com.ahmedmamdouh13.data.remote.RemoteService
import com.ahmedmamdouh13.domain.PostDomain
import com.ahmedmamdouh13.domain.Repository

class RepositoryImpl(
    private val remoteService: RemoteService,
    private val postsMapper: PostsMapper
) : Repository {

    override suspend fun requestNetworkPosts(): List<PostDomain>? {
        val androidDevPosts = remoteService.getAndroidDevPosts()

        println("here but i don't know !")
        val data = androidDevPosts.body()?.data
        println(androidDevPosts.code())
        println(androidDevPosts.body()?.kind)
        data?.children?.forEach {
            println(it.data.title)
        }

        return postsMapper.mapFromResonseToDomain(androidDevPosts.body()!!)
    }
}