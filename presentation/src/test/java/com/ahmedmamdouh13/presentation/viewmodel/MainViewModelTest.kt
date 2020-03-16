package com.ahmedmamdouh13.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.*
import com.ahmedmamdouh13.domain.Result
import com.ahmedmamdouh13.domain.abstraction.GetPostsInteractor
import com.ahmedmamdouh13.presentation.BaseViewModelTestSetup
import com.ahmedmamdouh13.presentation.GivenTestObject.postDomainList
import com.ahmedmamdouh13.presentation.GivenTestObject.postsList
import com.ahmedmamdouh13.presentation.mapper.PostMapper
import com.ahmedmamdouh13.presentation.model.Post
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.internal.runners.statements.ExpectException
import org.junit.rules.ExpectedException

class MainViewModelTest : BaseViewModelTestSetup() {

    @get:Rule
    override val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    override lateinit var lifecycleOwner: LifecycleOwner

    override lateinit var lifecycleRegistry: LifecycleRegistry


    @MockK
    lateinit var getPostsInteractor: GetPostsInteractor

    @MockK
    lateinit var mapper: PostMapper


    @Test
    fun `should succeed load posts`() = runBlocking {
        //given
        val mainViewModel = MainViewModel(getPostsInteractor, mapper)
        lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        val msg = "Success"
        val result = Result.Success(msg = msg, data = postDomainList)

        //when

        every {
            runBlocking {
                getPostsInteractor.getNetworkPosts()
            }
        } returns result

        every {
            lifecycleOwner.lifecycle
        } returns lifecycleRegistry

        every {
            mapper.mapFromDomainToPresentation(result.data)
        } returns postsList

        val observer = Observer<List<Post>> {
            println("what happened")
            assert(it[0].title == result.data[0].title)
            assert(it[1].desc == result.data[1].desc)
            assert(it[1].id == result.data[1].id)
            println(it[0].title == result.data[0].title)
        }
        val msgObserver = Observer<String> {
            println(msg)
            assert(it == msg)
        }

        mainViewModel._posts.observe(lifecycleOwner, observer)
        mainViewModel._showMsg.observe(lifecycleOwner, msgObserver)

        //then
        mainViewModel.onCreate()
        verify {
            mapper.mapFromDomainToPresentation(result.data)
        }

    }



    @Test
    fun `should fail load posts`() = runBlocking {
        //given
        val mainViewModel = MainViewModel(getPostsInteractor, mapper)
        lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        val msg = "Error"
        val result = Result.Error(msg, null)
        //when

        every {
            runBlocking {
                getPostsInteractor.getNetworkPosts()
            }
        } returns result

        every {
            lifecycleOwner.lifecycle
        } returns lifecycleRegistry


        val observer = Observer<String> {
            println(it)
            assert(it == msg)
        }

        mainViewModel._showMsg.observe(lifecycleOwner, observer)

        //then
        mainViewModel.onCreate()

        verify {
            runBlocking {
                getPostsInteractor.getNetworkPosts()
            }
        }

    }


}

