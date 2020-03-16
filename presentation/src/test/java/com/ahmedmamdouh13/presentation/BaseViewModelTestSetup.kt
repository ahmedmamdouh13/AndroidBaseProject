package com.ahmedmamdouh13.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.koin.ext.scope

abstract class BaseViewModelTestSetup {
    @get:Rule
    abstract val instantTaskExecutorRule: InstantTaskExecutorRule

    abstract var lifecycleRegistry: LifecycleRegistry

    @MockK
    abstract var lifecycleOwner: LifecycleOwner

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(newSingleThreadContext("single"))
    }
}