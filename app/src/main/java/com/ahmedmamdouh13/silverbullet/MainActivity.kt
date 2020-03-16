package com.ahmedmamdouh13.silverbullet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.ahmedmamdouh13.presentation.model.Post
import com.ahmedmamdouh13.presentation.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel._showMsg.observe(this, msgObserver)
        mainViewModel._posts.observe(this, postObserver)

        lifecycle.addObserver(mainViewModel)
    }

    private val msgObserver = Observer<String> {
        Toast.makeText(this, it, Toast.LENGTH_LONG).show()
    }

    private val postObserver = Observer<List<Post>> {
        it.forEach { post -> println(post.title) }
    }

}
