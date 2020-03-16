package com.ahmedmamdouh13.presentation.viewmodel

import androidx.lifecycle.*
import com.ahmedmamdouh13.domain.Result
import com.ahmedmamdouh13.domain.abstraction.GetPostsInteractor
import com.ahmedmamdouh13.domain.model.PostModelInterface
import com.ahmedmamdouh13.presentation.mapper.PostMapper
import com.ahmedmamdouh13.presentation.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val postsInteractor: GetPostsInteractor,
    private val mapper: PostMapper
) : ViewModel(),
    LifecycleObserver {

    var _posts = MutableLiveData<List<Post>>()
    var _showMsg = MutableLiveData<String>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        viewModelScope.launch {
            when (val result = postsInteractor.getNetworkPosts()) {
                is Result.Success<*> -> {
                    println("herea,ms")
                    _showMsg.value = (result.msg)
                    _posts.value = (
                        mapper.mapFromDomainToPresentation(
                            result.data as List<PostModelInterface>
                        )
                    )
                }
                is Result.Error -> {
                    _showMsg.postValue(result.msg)
                    result.e?.printStackTrace()
                }
            }
        }
    }
}