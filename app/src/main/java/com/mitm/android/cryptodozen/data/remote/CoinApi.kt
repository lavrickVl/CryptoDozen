package com.mitm.android.cryptodozen.data.remote

import com.mitm.android.cryptodozen.data.remote.dto.CoinDTO.Data
import com.mitm.android.cryptodozen.data.remote.dto.CoinDTO.DetailDTO
import com.mitm.android.cryptodozen.data.remote.dto.DTO.DTO
import retrofit2.http.GET

interface CoinApi {

    @GET("/v2/assets")
    suspend fun getCoins(): DTO

    @GET("/v2/assets/bitcoin")
    suspend fun getDetailCoin(): DetailDTO

}