package com.ahmedmamdouh13.presentation.viewmodel

import com.ahmedmamdouh13.domain.PostDomain
import com.ahmedmamdouh13.domain.abstraction.GetPostsInteractor
import com.ahmedmamdouh13.presentation.BaseTestSetup
import com.ahmedmamdouh13.presentation.mapper.PostMapper
import com.ahmedmamdouh13.presentation.model.Post
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MainViewModelTest : BaseTestSetup() {


    @MockK
    lateinit var getPostsInteractor: GetPostsInteractor

    @MockK
    lateinit var mapper: PostMapper


    @Test
    fun `should succeed load posts`() {
        //given
        val post1 = PostDomain().apply { title = "1" }
        val post2 = PostDomain().apply { title = "2" }
        val post3 = PostDomain().apply { title = "3" }
        val postList = listOf(post1, post2, post3)
        val mainViewModel = MainViewModel(getPostsInteractor, mapper)
        //when
        every {
            runBlocking {
                getPostsInteractor.getNetworkPosts()
            }
        } returns postList
        //then
        mainViewModel.onCreate()

    }
}
