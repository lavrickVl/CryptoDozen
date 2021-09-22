package com.mitm.android.cryptodozen.domain.repository

import com.mitm.android.cryptodozen.data.remote.dto.CoinDTO.Data
import com.mitm.android.cryptodozen.data.remote.dto.CoinDTO.DetailDTO
import com.mitm.android.cryptodozen.data.remote.dto.DTO.DTO

interface CoinRepository {

    suspend fun getCoins(): DTO

    suspend fun getDetailCoin(): DetailDTO
}