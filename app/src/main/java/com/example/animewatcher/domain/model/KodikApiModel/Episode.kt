package com.example.animewatcher.domain.model.KodikApiModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Episode(val number: Int, val link: String): Parcelable{}