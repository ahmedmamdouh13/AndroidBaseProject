package com.ahmedmamdouh13.silverbullet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.ahmedmamdouh13.presentation.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("onCreate")
        lifecycle.addObserver(mainViewModel)

        mainViewModel._posts.observe(this, Observer {
            it.forEach {post ->
                println(post.title)
            }
        })
    }

}
