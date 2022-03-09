package com.john.calendarevent.views

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.john.calendarevent.R

fun fragmentNavigation(supportFragmentManager:FragmentManager, fragment: Fragment) {

    supportFragmentManager.beginTransaction()
    .replace(R.id.main_fragment,fragment)
    .addToBackStack(fragment.id.toString())
    .commit()

}