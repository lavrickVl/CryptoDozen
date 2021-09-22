package com.mitm.android.cryptodozen.common

import android.util.Log

object Constants {
    const val TAG = "myLog"
    const val BASE_URL = "https://api.coincap.io/"


    operator fun invoke(msg: String) {
        Log.d(TAG, "log: $msg")
    }
}