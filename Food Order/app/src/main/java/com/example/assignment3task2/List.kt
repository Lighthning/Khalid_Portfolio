package com.example.assignment3task2

import android.os.Parcel
import android.os.Parcelable

data class List(var Number:Int, var List: String, var Prices: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readDouble()) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt(Number)
        p0?.writeString(List)
        p0?.writeDouble(Prices)
    }

    companion object CREATOR : Parcelable.Creator<List> {
        override fun createFromParcel(parcel: Parcel): List {
            return List(parcel)
        }

        override fun newArray(size: Int): Array<List?> {
            return arrayOfNulls(size)
        }
    }
}
