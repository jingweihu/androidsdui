package com.jingwei.sdui.network

import com.jingwei.sdui.core.RootResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkApi {
    @GET("home")
    suspend fun getHomeFeed(): RootResponse

}