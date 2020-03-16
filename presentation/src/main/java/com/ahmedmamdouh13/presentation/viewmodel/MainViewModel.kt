package com.ahmedmamdouh13.presentation.viewmodel

import androidx.lifecycle.*
import com.ahmedmamdouh13.domain.abstraction.GetPostsInteractor
import com.ahmedmamdouh13.presentation.mapper.PostMapper
import com.ahmedmamdouh13.presentation.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(
    val postsInteractor: GetPostsInteractor,
     val mapper: PostMapper
) : ViewModel(),
    LifecycleObserver {

    val _posts = MutableLiveData<List<Post>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        viewModelScope.launch(Dispatchers.IO) {
            val networkPosts = postsInteractor.getNetworkPosts()
            _posts.postValue(
                mapper.mapFromDomainToPresentation(
                    networkPosts!!
                )
            )
        }

    }
}