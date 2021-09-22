package com.mitm.android.cryptodozen.data.repository

import com.mitm.android.cryptodozen.data.remote.CoinApi
import com.mitm.android.cryptodozen.data.remote.dto.CoinDTO.Data
import com.mitm.android.cryptodozen.data.remote.dto.CoinDTO.DetailDTO
import com.mitm.android.cryptodozen.data.remote.dto.DTO.DTO
import com.mitm.android.cryptodozen.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
): CoinRepository {

    override suspend fun getCoins(): DTO {
        return api.getCoins()
    }

    override suspend fun getDetailCoin(): DetailDTO {
        return api.getDetailCoin()
    }
}