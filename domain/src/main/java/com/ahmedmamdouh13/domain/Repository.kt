package com.ahmedmamdouh13.domain

import com.ahmedmamdouh13.domain.model.PostDomain

interface Repository {
   suspend fun requestNetworkPosts(): Result
}