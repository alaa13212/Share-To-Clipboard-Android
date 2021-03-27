package me.barrak.sharetoclipboard.util

import android.util.*

inline val <reified T> T.TAG: String
    get() = T::class.java.simpleName

inline fun <reified T> T.logV(message: String) = Log.v(TAG, message)
inline fun <reified T> T.logI(message: String) = Log.i(TAG, message)
inline fun <reified T> T.logW(message: String) = Log.w(TAG, message)
inline fun <reified T> T.logD(message: String) = Log.d(TAG, message)
inline fun <reified T> T.logE(message: String) = Log.e(TAG, message)


