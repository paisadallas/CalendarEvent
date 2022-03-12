package com.john.calendarevent.data

import org.junit.Assert.*
import org.junit.Test
class compareDateTest(){

    var compareDate = compareDate ()

    @Test
    fun test_day_one_number(){
        var currentDay = "1/1/2000"
        var eventDay = "1/1/2000"
        assertEquals("0",compareDate.compareString(currentDay,eventDay))
    }
}