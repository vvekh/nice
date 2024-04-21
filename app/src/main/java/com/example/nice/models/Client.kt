package com.example.nice.models

import android.os.Parcel
import android.os.Parcelable

class Client() : Parcelable {
    var id = 0
    var username: String? = null
    var birthdate: String? = null
    var login: String? = null
    var password: String? = null
    var timelineid = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        username = parcel.readString()
        birthdate = parcel.readString()
        login = parcel.readString()
        password = parcel.readString()
        timelineid = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(username)
        parcel.writeString(birthdate)
        parcel.writeString(login)
        parcel.writeString(password)
        parcel.writeInt(timelineid)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Client> {
        override fun createFromParcel(parcel: Parcel): Client {
            return Client(parcel)
        }

        override fun newArray(size: Int): Array<Client?> {
            return arrayOfNulls(size)
        }
    }
}
