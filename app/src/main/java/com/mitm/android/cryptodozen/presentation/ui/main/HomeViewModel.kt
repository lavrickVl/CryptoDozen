package com.mitm.android.cryptodozen.presentation.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mitm.android.cryptodozen.common.Constants
import com.mitm.android.cryptodozen.domain.model.Coin
import com.mitm.android.cryptodozen.domain.usecases.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetCoinUseCase
) : ViewModel() {


    private val _coinsList = MutableLiveData<List<Coin>>()
    val coinList: LiveData<List<Coin>> = _coinsList

    init {
        getCoins()
    }

    fun getCoins() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val deferred = viewModelScope.async {
                useCase.invoke()
            }

            withContext(Dispatchers.Main) {
                _coinsList.value = deferred.await()
//                Log.d("myLog.Coin", "${_coinsList.value!![0]}")
            }
        } catch (ex: HttpException) {
            Constants("Oyo, http :(")
        }
    }


    fun getDetail() = viewModelScope.launch {

        try {
            val deffered = viewModelScope.async {
                useCase.getDetail()
            }

            withContext(Dispatchers.Main) {
                Log.d("myLog.Coin", "${deffered.await()}")
            }
        } catch (ex: HttpException) {
            Log.d("myLog.Coin", "getDetail: 429")
        }
    }
}