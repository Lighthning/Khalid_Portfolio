package com.example.assignment04_task01

import android.os.Parcel
import android.os.Parcelable

data class Items(val type:String, val image:String, val name: String,val url: String, val processor: String, val storage: String, val camera: String): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(type)
        p0?.writeString(image)
        p0?.writeString(name)
        p0?.writeString(url)
        p0?.writeString(processor)
        p0?.writeString(storage)
        p0?.writeString(camera)
    }

    companion object CREATOR : Parcelable.Creator<Items> {
        override fun createFromParcel(parcel: Parcel): Items {
            return Items(parcel)
        }

        override fun newArray(size: Int): Array<Items?> {
            return arrayOfNulls(size)
        }
    }

}