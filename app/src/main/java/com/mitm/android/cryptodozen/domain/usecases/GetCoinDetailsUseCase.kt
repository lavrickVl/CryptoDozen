package com.mitm.android.cryptodozen.domain.usecases

 import com.mitm.android.cryptodozen.data.remote.dto.CoinDTO.Data
 import com.mitm.android.cryptodozen.data.remote.dto.CoinDTO.DetailDTO
 import com.mitm.android.cryptodozen.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinDetailsUseCase  @Inject constructor(
    private val repository: CoinRepository
) {

    suspend operator fun invoke(): DetailDTO {
        return repository.getDetailCoin()
    }
}