package com.ahmedmamdouh13.data.mapper

import com.ahmedmamdouh13.data.remote.RedditResponse
import com.ahmedmamdouh13.domain.PostDomain

class PostsMapper {
    fun mapFromResonseToDomain(response: RedditResponse): List<PostDomain>? {
        return response.data.children.map {
            PostDomain().apply {
                this.title = it.data.title
                this.desc = it.data.thumbnail
            }
        }
    }
}