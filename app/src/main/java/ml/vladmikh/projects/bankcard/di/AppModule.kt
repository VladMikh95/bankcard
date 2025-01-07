package ml.vladmikh.projects.bankcard.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ml.vladmikh.projects.bankcard.data.network.ApiService
import ml.vladmikh.projects.bankcard.data.repository.CardInfoRemoteDataSourceRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseUrl(): String = "https://lookup.binlist.net"


    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)



    @Provides
    @Singleton
    fun provideCardInfoRemoteDataSourceRepository(apiService: ApiService):
            CardInfoRemoteDataSourceRepository = CardInfoRemoteDataSourceRepository(apiService)


}