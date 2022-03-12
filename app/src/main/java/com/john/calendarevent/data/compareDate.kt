package com.john.calendarevent.data

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class compareDate {

    fun compareString(currentDate:String, eventDate:String):String{

        /**
         * This algorithm find the different between two dates
         */

       val formatter = SimpleDateFormat("dd/MM/yyyy")
        var date1 : Date? = formatter.parse(currentDate)
        var date2 : Date?= formatter.parse(eventDate)
        var diferent = date2?.getTime()?.minus(date1?.getTime()!!)
        var diferentString = diferent?.div(86400000)
        return "$diferentString"
    }
}