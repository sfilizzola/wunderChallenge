package dev.com.sfilizzola.wunderchallenge.database

import android.arch.persistence.room.TypeConverter

class Converter {

    @TypeConverter
    fun fromString(value: String): ArrayList<Double> {
        val arrayList = ArrayList<Double>()

        val splitValue = value.split("/")

        for (strNumber in splitValue) {
            if (strNumber.isNotEmpty())
                arrayList.add(strNumber.toDouble())
        }
        return arrayList
    }

    @TypeConverter
    fun coordinatesToString(value: ArrayList<Double>): String {

        var final = ""

        for ((index, item) in value.withIndex()) {

            final += item.toString()

            if ((index - 1) != value.size) {
                final += "/"
            }

        }
        return final
    }
}