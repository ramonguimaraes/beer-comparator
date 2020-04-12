package com.ramonguimaraes.beercomparator

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Cerveja(
    val marca: String,
    val preco: Double,
    val litragem: Int,
    val precolitro: Double
): Parcelable


