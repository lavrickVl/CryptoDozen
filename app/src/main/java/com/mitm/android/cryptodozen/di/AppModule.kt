package com.mitm.android.cryptodozen.di

import com.mitm.android.cryptodozen.common.Constants
import com.mitm.android.cryptodozen.data.repository.CoinRepositoryImpl
import com.mitm.android.cryptodozen.data.remote.CoinApi
import com.mitm.android.cryptodozen.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providerApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun providerRepository(api: CoinApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }


}