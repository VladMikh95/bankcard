package ml.vladmikh.projects.bankcard.data.network

import ml.vladmikh.projects.bankcard.data.network.model.CardInfoRemoteDataSource
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/{bin}")
    suspend fun getCardInfo(@Path(value="bin")bin : Int): CardInfoRemoteDataSource
}