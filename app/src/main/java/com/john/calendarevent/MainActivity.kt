package com.john.calendarevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.john.calendarevent.ui.fragments.DataFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment,DataFragment.newInstance("",""))
            .addToBackStack(null)
            .commit()
    }
}