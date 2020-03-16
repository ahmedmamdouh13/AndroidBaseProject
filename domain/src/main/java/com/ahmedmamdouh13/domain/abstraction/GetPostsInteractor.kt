package com.ahmedmamdouh13.domain.abstraction

import com.ahmedmamdouh13.domain.PostDomain

interface GetPostsInteractor {
   suspend fun getNetworkPosts(): List<PostDomain>?

}
