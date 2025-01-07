package ml.vladmikh.projects.bankcard.data.repository

import ml.vladmikh.projects.bankcard.data.network.ApiService
import javax.inject.Inject

class CardInfoRemoteDataSourceRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCardInfo(bin: Int) = apiService.getCardInfo(bin)
}