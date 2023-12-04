package com.example.animewatcher.domain.model.KodikApiModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Translation (
    val id: Int,
    val title: String,
    val type: String
): Parcelable{

}

