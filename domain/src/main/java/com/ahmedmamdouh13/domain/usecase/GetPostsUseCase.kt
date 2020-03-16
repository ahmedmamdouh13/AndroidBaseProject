package com.ahmedmamdouh13.domain.usecase

import com.ahmedmamdouh13.domain.PostDomain
import com.ahmedmamdouh13.domain.Repository
import com.ahmedmamdouh13.domain.abstraction.GetPostsInteractor

class GetPostsUseCase(private val repository: Repository): GetPostsInteractor {
    override suspend fun getNetworkPosts(): List<PostDomain>? {
        return repository.requestNetworkPosts()
    }

}
