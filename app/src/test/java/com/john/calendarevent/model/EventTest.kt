package com.john.calendarevent.model

import org.junit.Assert.*

import org.junit.Test

class EventTest {

    var event:Event = Event("1","2","3","4")
    @Test
    fun getId() {
        setId()
        assertEquals("2",event.id)

    }

    @Test
    fun setId() {
        event.id="2"
    }

    @Test
    fun getTitle() {
    }

    @Test
    fun getCategory() {
    }

    @Test
    fun getCalendar() {
    }

    @Test
    operator fun component1() {
    }

    @Test
    operator fun component2() {
    }

    @Test
    operator fun component3() {
    }

    @Test
    operator fun component4() {
    }
}