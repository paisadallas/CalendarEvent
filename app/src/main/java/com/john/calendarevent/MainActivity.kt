package com.john.calendarevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.john.calendarevent.views.CalendarFragment
import com.john.calendarevent.views.Communicator
import com.john.calendarevent.views.DataFragment


class MainActivity : AppCompatActivity(), Communicator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main_fragment,)
//            .addToBackStack(null)
//            .commit()
    }

    override fun swithCalendarFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment,CalendarFragment.newInstance("",""))
            .addToBackStack(null)
            .commit()
    }

    override fun swithDataFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment,DataFragment.newInstance("",""))
            .addToBackStack(null)
            .commit()
    }

}