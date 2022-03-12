package com.john.calendarevent.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parceler

@Entity
data class Event(
    @PrimaryKey
    var id:String?,
    val title:String?,
    val category : String?,
    val calendar: String?
)





