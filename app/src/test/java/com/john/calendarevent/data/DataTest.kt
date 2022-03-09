package com.john.calendarevent.data

import com.john.calendarevent.model.Event
import org.junit.Assert.*

import org.junit.Test

class DataTest {

    var event0: Event = Event("1","work","work","12/13/2022")
    var event1:Event = Event("5","grocery","hobbies","11/10/2021")
    var event2:Event = Event("45","emergency","hospital","01/08/1998")
    var event3:Event = Event("17","sport","soccer","07/04/2006")
    var event4:Event = Event("13","family","mother","03/04/1992")
    var event5:Event = Event("79","travel","paris","01/04/1995")
    var event6:Event = Event("98","study","pays","09/04/2003")
    var data: ArrayList<Event> = arrayListOf()

    fun addAllList(){
        data.add(event0)
        data.add(event1)
        data.add(event2)
        data.add(event3)
        data.add(event4)
        data.add(event5)
        data.add(event6)
    }

    @Test
    fun getListEvent() {
        addAllList()
        assertEquals("work",data[0].title)
    }

    @Test
    fun deleteThirdElement(){
        addAllList()
        assertEquals("emergency",data[2].title)

        data.remove(event2)
        assertEquals("sport",data[2].title)
    }

    @Test
    fun addFirstElement(){
        addAllList()
        data.add(0,event4)
        assertEquals("family",data[0].title)
    }
}