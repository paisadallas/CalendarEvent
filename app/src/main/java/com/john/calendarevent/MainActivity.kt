package com.john.calendarevent

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.john.calendarevent.adapter.EventAdapterListener
import com.john.calendarevent.data.Data
import com.john.calendarevent.model.Event
import com.john.calendarevent.views.*


class MainActivity : AppCompatActivity(),EventAdapterListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,DataFragment())
                .addToBackStack(null)
                .commit()
        }
}

    override fun onFragmentCliked(id: String) {
        Log.d("READING_ID=","${id}")
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView,ConsultFragment.newInstance(id),"DATA")
            .addToBackStack("DATA")
            .commit()
    }

}