package com.example.assignment05

import android.os.Parcel
import android.os.Parcelable

data class items(val id:Int, var img:Int, var name:String, var detail: String, var quantity:String, var size:String, var urgent: String, var bought: String) : Parcelable{

    constructor(img: Int?, name: String, detail: String, quantity: String, size: String, urgent: String, bought: String) : this(-1, img!!, name, detail,quantity, size, urgent, bought)

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
        ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(img)
        parcel.writeString(name)
        parcel.writeString(detail)
        parcel.writeString(quantity)
        parcel.writeString(size)
        parcel.writeString(urgent)
        parcel.writeString(bought)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<items> {
        override fun createFromParcel(parcel: Parcel): items {
            return items(parcel)
        }

        override fun newArray(size: Int): Array<items?> {
            return arrayOfNulls(size)
        }
    }

}