package com.example.assignment3_task1

import android.os.Parcel
import android.os.Parcelable

data class Details(val image:Int ,var name:String, var area:String, var stars:String, var rm:String, var size: String, var distance: String, var facilities: String, var roomtypes:String):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(area)
        parcel.writeString(stars)
        parcel.writeString(rm)
        parcel.writeString(size)
        parcel.writeString(distance)
        parcel.writeString(facilities )
        parcel.writeString(roomtypes )
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Details> {
        override fun createFromParcel(parcel: Parcel): Details {
            return Details(parcel)
        }

        override fun newArray(size: Int): Array<Details?> {
            return arrayOfNulls(size)
        }
    }
}
//    : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readInt(),
//        parcel.readString()!!){
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    override fun writeToParcel(p0: Parcel?, p1: Int) {
//        p0?.writeString(name)
//        p0?.writeString(area)
//        p0?.writeString(stars)
//        p0?.writeString(rm)
//    }
//
//    companion object CREATOR : Parcelable.Creator<Details> {
//        override fun createFromParcel(parcel: Parcel): Details {
//            return Details(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Details?> {
//            return arrayOfNulls(size)
//        }
//    }
//}
