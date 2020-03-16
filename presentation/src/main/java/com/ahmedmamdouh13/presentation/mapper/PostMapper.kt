package com.ahmedmamdouh13.presentation.mapper

import com.ahmedmamdouh13.domain.model.PostModelInterface
import com.ahmedmamdouh13.presentation.model.Post

class PostMapper {
    fun mapFromDomainToPresentation(networkPosts: List<PostModelInterface>): List<Post> {
        return networkPosts.map {
            Post().apply {
                this.title = it.title
                this.desc = it.desc
                this.id = it.id
            }
        }
    }

}