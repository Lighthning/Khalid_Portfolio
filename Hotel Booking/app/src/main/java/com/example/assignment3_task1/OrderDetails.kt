package com.example.assignment3_task1

import android.os.Parcel
import android.os.Parcelable

data class OrderDetails(val image:Int, val hotelname:String, val roomtype:String, val checkindate:String, val checkoutdate:String, val totalamt:String):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(hotelname)
        parcel.writeString(roomtype)
        parcel.writeString(checkindate)
        parcel.writeString(checkoutdate)
        parcel.writeString(totalamt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OrderDetails> {
        override fun createFromParcel(parcel: Parcel): OrderDetails {
            return OrderDetails(parcel)
        }

        override fun newArray(size: Int): Array<OrderDetails?> {
            return arrayOfNulls(size)
        }
    }

}
