package com.john.calendarevent.views

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.navigation.fragment.findNavController
import com.john.calendarevent.R
import com.john.calendarevent.data.Data
import com.john.calendarevent.databinding.FragmentCalendarBinding
import com.john.calendarevent.model.Event
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment() {

    private lateinit var binding : FragmentCalendarBinding

   //SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_calendar, container, false)
        binding = FragmentCalendarBinding.inflate(inflater,container,false)

        binding.btCancel.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                DataFragment()
            )
        }

            binding.calendarView.setOnDateChangeListener { _, p1, p2, p3 ->
               val id: UUID = UUID.randomUUID()
                Log.d("DAY_CALENDAR", "$p1$p2$p3")
                var title: String = binding.etEvent.text.toString()
                var category: String = binding.etCategory.text.toString()

                var date = "$p3/$p2/$p1"

                binding.btOkEvent.setOnClickListener {
                    var event= Event(id.toString(), title, category, date)
                    Data.listEvent.add(event)
                    fragmentNavigation(
                        supportFragmentManager = requireActivity().supportFragmentManager,
                        DataFragment()
                    )
                }
            }
        return binding.root
    }
}