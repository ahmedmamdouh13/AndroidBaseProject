package com.ahmedmamdouh13.presentation

import com.ahmedmamdouh13.domain.model.PostDomain
import com.ahmedmamdouh13.presentation.model.Post

object GivenTestObject {
    val post1 = PostDomain()
        .apply {
            title = "title1"
            desc  = "desc1"
            id  = 1
        }
    val post2 = PostDomain()
        .apply {
            title = "title2"
            desc  = "desc2"
            id  = 2
        }
    val post3 = PostDomain()
        .apply {
            title = "title3"
            desc  = "desc3"
            id  = 3
        }
    val postDomainList = listOf(post1, post2, post3)

    val postsList = postDomainList.map {
        Post().apply {
            this.title = it.title
            this.desc = it.desc
            this.id = it.id
        }
    }
}