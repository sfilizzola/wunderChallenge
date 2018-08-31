package dev.com.sfilizzola.wunderchallenge.network

import dev.com.sfilizzola.wunderchallenge.network.networkModels.BasicResponse
import io.reactivex.Single
import retrofit2.http.GET



interface NetworkClient {

    @GET("locations.json")
    fun getLocationResponse() : Single<BasicResponse>

}