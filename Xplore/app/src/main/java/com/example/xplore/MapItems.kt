package com.example.xplore

import android.os.Parcel
import android.os.Parcelable

data class MapItems(val id:Int, var img:String, var address: String, var latitude:Double, var longitude:Double):Parcelable{

    constructor(img: String, address: String, latitude: Double, longitude: Double) : this(-1, img, address, latitude, longitude)

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readDouble()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(img)
        parcel.writeString(address)
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MapItems> {
        override fun createFromParcel(parcel: Parcel): MapItems {
            return MapItems(parcel)
        }

        override fun newArray(size: Int): Array<MapItems?> {
            return arrayOfNulls(size)
        }
    }

}
