package com.ahmedmamdouh13.domain

sealed class Result {
    data class Success<T>(val msg: String = "Success.", val data: T): Result()
    data class Error(val msg: String = "Failed.", val e: Exception?): Result()
//    data class Loading(val msg: String = "In Progress."): Result()
}