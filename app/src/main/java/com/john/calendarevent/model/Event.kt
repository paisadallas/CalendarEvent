package com.john.calendarevent.model

import android.os.Parcel
import android.os.Parcelable

import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parceler


@Parcelize
data class Event(
    var id:String?,
    val title:String?,
    val category : String?,
    val calendar: String?
) : Parcelable





