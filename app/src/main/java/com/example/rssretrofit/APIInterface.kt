package com.example.rssretrofit


import com.example.rssretrofit.Model.RSS
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @get:GET("rss?topic=h&hl=en-US&gl=US&ceid=US:en")
    val feed: Call<RSS?>?

    companion object {
        const val BASE_URL = "https://news.google.com/"
    }
}