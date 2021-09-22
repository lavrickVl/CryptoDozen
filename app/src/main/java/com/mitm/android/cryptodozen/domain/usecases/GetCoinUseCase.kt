package com.mitm.android.cryptodozen.domain.usecases

import com.mitm.android.cryptodozen.data.remote.dto.CoinDTO.Data
import com.mitm.android.cryptodozen.data.remote.dto.CoinDTO.toCoin
import com.mitm.android.cryptodozen.data.remote.dto.DTO.toCoin
import com.mitm.android.cryptodozen.domain.model.Coin
import com.mitm.android.cryptodozen.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinUseCase  @Inject constructor(
    private val repository: CoinRepository
) {

    suspend operator fun invoke(): List<Coin> {
        return repository.getCoins().data.map {
            it.rank?.toInt() ?: 99 <= 12
                it.toCoin()
        }
    }


    suspend fun getDetail(): Coin {
        return repository.getDetailCoin().data.toCoin()
    }
}