package com.jingwei.sdui.repository

import android.util.Log
import com.jingwei.sdui.core.component.SduiComponent
import com.jingwei.sdui.core.mappers.SduiCoreMapper
import com.jingwei.sdui.network.NetworkApi
import javax.inject.Inject

class SduiRepository @Inject constructor(
    private val networkApi: NetworkApi,
    private val sduiCoreMapper: SduiCoreMapper
) {

   suspend fun getHomeFeed(): SduiComponent {
        val feed = networkApi.getHomeFeed()
        val result = sduiCoreMapper.parseComponent(feed.content)
         Log.d("Feed Network", result.toString())
        return result

   }
}