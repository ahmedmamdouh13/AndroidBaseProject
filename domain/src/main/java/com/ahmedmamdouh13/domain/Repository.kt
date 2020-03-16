package com.ahmedmamdouh13.domain

interface Repository {
   suspend fun requestNetworkPosts(): List<PostDomain>?
}