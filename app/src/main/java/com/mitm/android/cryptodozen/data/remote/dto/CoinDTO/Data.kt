package com.mitm.android.cryptodozen.data.remote.dto.CoinDTO

import com.mitm.android.cryptodozen.domain.model.Coin
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.round

data class Data(
    val changePercent24Hr: String?,
    val id: String?,
    val marketCapUsd: String?,
    val maxSupply: String?,
    val name: String?,
    val priceUsd: String?,
    val rank: String?,
    val supply: String?,
    val symbol: String?,
    val volumeUsd24Hr: String?,
    val vwap24Hr: String?
)


    fun Data.toCoin(): Coin {

        fun String.roundedBn(): String {
            val df = DecimalFormat("###.##")
            df.roundingMode = RoundingMode.CEILING
            return df.format(this.toDouble() / 1000_000_000)
        }

        fun String.roundedPercent(): String {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING
            return df.format(this.toDouble())
        }

        return Coin(
            changePercent24Hr = changePercent24Hr?.roundedPercent() + "%",
            id = id,
            marketCapUsd = "MCap $" + (marketCapUsd?.roundedBn() ?: "") + "Bn",
            maxSupply = "MaxSup " + (maxSupply?.roundedBn() ?: "") + "Bn",
            name = name,
            priceUsd = (round((priceUsd?.toDouble() ?: 0.0) * 100) / 100).toString() + " $",
            rank = rank,
            supply = "Sup " + (supply?.roundedBn() ?: "") + " $",
            symbol = symbol,
            volumeUsd24Hr = "Vol24 $" + (volumeUsd24Hr?.roundedBn() ?: "") + "Bn"
        )
}