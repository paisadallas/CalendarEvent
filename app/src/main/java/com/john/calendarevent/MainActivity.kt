package com.john.calendarevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.john.calendarevent.adapter.EventAdapterListener
import com.john.calendarevent.data.Data
import com.john.calendarevent.model.Event
import com.john.calendarevent.views.*


class MainActivity : AppCompatActivity(),EventAdapterListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentNavigation(supportFragmentManager,DataFragment.newInstance("",""))

    }

    override fun onFragmentCliked(id: String) {
        Log.d("READING_ID=","${id}")
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment,ConsultFragment.newInstance(id,""))
            .addToBackStack(null)
            .commit()
    }
}