package com.mitm.android.cryptodozen.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mitm.android.cryptodozen.R
import com.mitm.android.cryptodozen.common.Constants
import com.mitm.android.cryptodozen.databinding.ItemCoinBinding
import com.mitm.android.cryptodozen.domain.model.Coin
import kotlin.math.round

class CoinsRecyclerAdapter : RecyclerView.Adapter<CoinsRecyclerAdapter.CoinViewHolder>() {

    inner class CoinViewHolder(val binding: ItemCoinBinding) : RecyclerView.ViewHolder(binding.root)

    private var coinsList: List<Coin> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        if (coinsList.isNotEmpty()) {
            val name = coinsList[position].rank + ". " +
                       coinsList[position].name + " (" +
                       coinsList[position].symbol + ")"

            Constants(name)

            with(holder) {
                binding.tvRankSymbName.text = name
                binding.tvChange.text = coinsList[position].changePercent24Hr
                binding.tvMarketCap.text = coinsList[position].marketCapUsd
                binding.tvMaxSupply.text = coinsList[position].maxSupply
                binding.tvPrice.text = coinsList[position].priceUsd
                binding.tvSupply.text = coinsList[position].supply
                binding.tvVolume24.text = coinsList[position].volumeUsd24Hr
            }
        }
    }

    override fun getItemCount(): Int {
        return 12
    }


    @SuppressLint("NotifyDataSetChanged")
    fun loadCoins(_coinsList: List<Coin>) {
        coinsList = _coinsList
        notifyDataSetChanged()
    }
}