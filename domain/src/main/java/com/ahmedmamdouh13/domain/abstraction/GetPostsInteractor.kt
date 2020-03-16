package com.ahmedmamdouh13.domain.abstraction

import com.ahmedmamdouh13.domain.Result
import com.ahmedmamdouh13.domain.model.PostDomain

interface GetPostsInteractor {
   suspend fun getNetworkPosts(): Result

}
