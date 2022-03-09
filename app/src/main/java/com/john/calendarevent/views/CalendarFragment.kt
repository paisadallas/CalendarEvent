package com.john.calendarevent.views

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import com.john.calendarevent.R
import com.john.calendarevent.data.Data
import com.john.calendarevent.databinding.FragmentCalendarBinding
import com.john.calendarevent.model.Event
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalendarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalendarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : FragmentCalendarBinding
    private lateinit var communicator: Communicator
   //SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
    var sdf:SimpleDateFormat = SimpleDateFormat("yyyy/MM/dd")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = activity as Communicator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_calendar, container, false)
        binding = FragmentCalendarBinding.inflate(inflater,container,false)

        binding.btCancel.setOnClickListener {

         //   Data.event_data = "CalendarFragment"
          //  Log.d("READING_DATA","Reading data from Calendar: ${Data.event_data}")
            communicator.swithDataFragment()
        }

            binding.calendarView.setOnDateChangeListener { p0, p1, p2, p3 ->
                Log.d("DAY_CALENDAR", "$p1$p2$p3")
                var title: String = binding.etEvent.text.toString()
                var category: String = binding.etCategory.text.toString()

                var date = "$p3/$p2/$p1"

                binding.btOkEvent.setOnClickListener {
                    var event: Event = Event("001", title, category, date)
                    Data.listEvent?.add(event)
                    communicator.swithDataFragment()
                }

            }
            // Log.d("DAY_CALENDAR",date)

            Log.d("LIST_SIZE",Data.listEvent?.size.toString())

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalendarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalendarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}