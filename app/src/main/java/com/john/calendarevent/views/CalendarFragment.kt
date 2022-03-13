package com.john.calendarevent.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.john.calendarevent.R
import com.john.calendarevent.data.Data
import com.john.calendarevent.databinding.FragmentCalendarBinding
import com.john.calendarevent.model.Event
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment() {

    private lateinit var binding : FragmentCalendarBinding
    private val formatter = SimpleDateFormat("dd/MM/yyyy")
    private var date: String = formatter.format(Date())
    private lateinit var event:Event
    val id: UUID = UUID.randomUUID()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCalendarBinding.inflate(inflater,container,false)

        binding.btCancel.setOnClickListener {
            findNavController().navigate(R.id.action_calendar_to_data)
        }

        binding.calendarView.apply {
            minDate = date
        }

        enableButton(binding.etEvent,binding.etCategory,binding.btOkEvent)

            binding.calendarView.setOnDateChangeListener { _, p1, p2, p3 ->

                 this.date = "${p3}/${p2+1}/$p1"

                sendData("${binding.etEvent.text}","${binding.etCategory.text}",date)

            }

        return binding.root
    }

    private fun enableButton(etEvent: EditText, etCategory: EditText, btOkEvent: Button){

        //Listen etEvent
        etEvent.doAfterTextChanged { itEvent ->

            if ("$itEvent" !=""){
                etCategory.doAfterTextChanged {itCategory ->
                    btOkEvent.isEnabled = "$itCategory" != ""
                    sendData("$itEvent","$itCategory",this.date)
                }
            }else{
                btOkEvent.isEnabled = false
            }
        }

        //Listen etCategory
        etCategory.doAfterTextChanged { itCategory ->

            if ("$itCategory" !=""){
                etEvent.doAfterTextChanged {itEvent ->
                    btOkEvent.isEnabled = "$itEvent" != ""
                    sendData("$itEvent","$itCategory",this.date)
                }
            }else{
                btOkEvent.isEnabled = false
            }
        }
    }

    private fun sendData(etEvent: String, etCategory: String, date: String) {
        binding.btOkEvent.setOnClickListener {
            event= Event("$id", etEvent, etCategory, date)
            Data.listEvent.add(event)

            findNavController().navigate(R.id.action_calendar_to_data)
        }
    }
}