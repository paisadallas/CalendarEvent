package com.john.calendarevent.views

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.john.calendarevent.MainActivity
import com.john.calendarevent.R
import com.john.calendarevent.adapter.EventAdapter
import com.john.calendarevent.adapter.EventAdapterListener
import com.john.calendarevent.data.Data
import com.john.calendarevent.databinding.FragmentCalendarBinding
import com.john.calendarevent.databinding.FragmentDataBinding

class DataFragment : Fragment() {

    private lateinit var eventAdapterListener: EventAdapterListener
    private  var c= 0
    private val binding by lazy {
        FragmentDataBinding.inflate(layoutInflater)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        eventAdapterListener = activity as EventAdapterListener

    }

    private val eventAdapter by lazy {
        EventAdapter(eventAdapterListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for (i in 0 until (Data.listEvent.size )){

            eventAdapter.updateEventData(Data.listEvent[i])
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding.rvData.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = eventAdapter
        }

     //   val view = binding.root
      //  var navController=Navigation.findNavController(MainActivity()!!, R.id.nav_graph)
        binding.btnAddEvent.setOnClickListener {
            findNavController().navigate(R.id.action_data_to_calendar)
        }


        return binding.root
    }



}