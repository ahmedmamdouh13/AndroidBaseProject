package com.ahmedmamdouh13.domain.usecase

import com.ahmedmamdouh13.domain.model.PostDomain
import com.ahmedmamdouh13.domain.Repository
import com.ahmedmamdouh13.domain.Result
import com.ahmedmamdouh13.domain.abstraction.GetPostsInteractor

class GetPostsUseCase(private val repository: Repository): GetPostsInteractor {
    override suspend fun getNetworkPosts(): Result {
        return repository.requestNetworkPosts()
    }

}
