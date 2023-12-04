package com.example.animewatcher.domain.model.KodikApiModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Season (
    val link: String,
    val episodes: Map<String, String>
): Parcelable {}

