package com.john.calendarevent.views

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.john.calendarevent.adapter.EventAdapter
import com.john.calendarevent.data.Data
import com.john.calendarevent.databinding.FragmentDataBinding
import com.john.calendarevent.model.Event

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DataFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //DATA

//    var event0: Event = Event("1","work","work","12/13/2022")
//    var event1:Event = Event("5","grocery","hobbies","11/10/2021")
//    var event2:Event = Event("45","emergency","hospital","01/08/1998")
//    var event3:Event = Event("17","sport","soccer","07/04/2006")
//    var event4:Event = Event("13","family","mother","03/04/1992")
//    var event5:Event = Event("79","travel","paris","01/04/1995")
//    var event6:Event = Event("98","study","pays","09/04/2003")
//    var data: ArrayList<Event> = arrayListOf()
//
//    fun addAllList(){
//        data.add(event0)
//        data.add(event1)
//        data.add(event2)
//        data.add(event3)
//        data.add(event4)
//        data.add(event5)
//        data.add(event6)
//    }


    //DATA

    private lateinit var communicator: Communicator
    private  var c= 0
    private val binding by lazy {
        FragmentDataBinding.inflate(layoutInflater)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = activity as Communicator

       // addAllList()
    }

    private val eventAdapter by lazy {
        EventAdapter(communicator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_data, container, false)
        binding.rvData.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = eventAdapter
        }

        Log.d("LIST_SIZE",Data.listEvent.size.toString())

        for (i in 0 until (Data.listEvent.size )){

            eventAdapter.updateEventData(Data.listEvent[i])
        }

        //ADDING NEW ITEM
//        binding.btnAddEvent.setOnClickListener {
//            eventAdapter.updateEventData(Event("id ${c}","hola ${c}","mundo","como"))
//            c++
//        }

        //CALL FRAGMENT CALENDAR
        binding.btnAddEvent.setOnClickListener {
            //send data to MainActivity
       //     Data.event_data="Event from DataFragment"
            communicator.swithCalendarFragment()

        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DataFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}