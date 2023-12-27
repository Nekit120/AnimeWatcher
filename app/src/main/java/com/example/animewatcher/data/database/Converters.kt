package com.example.animewatcher.data.database

import androidx.room.TypeConverter
import com.example.animewatcher.domain.model.KodikApiModel.MaterialData
import com.example.animewatcher.domain.model.KodikApiModel.Season
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromMaterialData(value: String?): MaterialData? {
        val type = object : TypeToken<MaterialData>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toMaterialData(value: MaterialData?): String {
        return Gson().toJson(value)
    }
    //**************************************************************
    @TypeConverter
    fun fromSeason(value: String): Season {
        val type = object : TypeToken<Season>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toSeason(value: Season): String {
        return Gson().toJson(value)
    }
    //**************************************************************
    @TypeConverter
    fun fromListString(value: String?): List<String>? {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toListString(value: List<String>?): String {
        return Gson().toJson(value)
    }
    //**************************************************************
    @TypeConverter
    fun fromString(value: String?): Map<String, Season>? {
        val type = object : TypeToken<Map<String, Season>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toString(value: Map<String, Season>?): String {
        return Gson().toJson(value)
    }
}