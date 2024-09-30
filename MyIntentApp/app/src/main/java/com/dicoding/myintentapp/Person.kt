package com.dicoding.myintentapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    companion object : Parceler<Person> {

        override fun Person.write(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeValue(age)
            parcel.writeString(email)
            parcel.writeString(city)
        }

        override fun create(parcel: Parcel): Person {
            return Person(parcel)
        }
    }
}
