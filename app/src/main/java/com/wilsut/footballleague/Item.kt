package com.wilsut.footballleague

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(val name: String?, val image: Int?, val description: String?) : Parcelable