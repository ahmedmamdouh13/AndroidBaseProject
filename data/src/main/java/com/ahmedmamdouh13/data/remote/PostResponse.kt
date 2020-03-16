package com.ahmedmamdouh13.data.remote

class RedditResponse {
    lateinit var data: Data
    lateinit var kind: String
}

class Data {
    lateinit var children: List<PostResponse>
    lateinit var modhash: String
    var dist: Int = -1
    lateinit var after: String
    lateinit var before: String
}

class PostResponse {
    lateinit var kind: String
    lateinit var data: PostData

}

class PostData {
    var title: String = ""
    var thumbnail: String = ""
}
