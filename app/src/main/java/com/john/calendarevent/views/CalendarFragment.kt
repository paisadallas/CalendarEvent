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

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCalendarBinding.inflate(inflater,container,false)

        binding.btCancel.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                DataFragment()
            )

        }

        enableButton(binding.etEvent,binding.etCategory,binding.btOkEvent)


        var current_day = formatter.format(Date())


            binding.calendarView.setOnDateChangeListener { _, p1, p2, p3 ->

                 this.date = "${p3}/${p2+1}/$p1"

              //   var myDate :Date =  formatter.parse("07-01-2022")
              //  var mill = myDate.time as Long
              //  Log.d("TIME_LONG","${mill}")

                /*
                binding.btOkEvent.setOnClickListener {
                     event= Event("$id", "${binding.etEvent.text}", "${binding.etCategory.text}", date)
                    Data.listEvent.add(event)
                    fragmentNavigation(
                        supportFragmentManager = requireActivity().supportFragmentManager,
                        DataFragment()
                    )
                }
                */
                sendData("${binding.etEvent.text}","${binding.etCategory.text}",date)

            }



        //val my_date = SimpleDateFormat("dd")
        val my_month = SimpleDateFormat("MM")
        val my_year = SimpleDateFormat("yyyy")
       // val currentDate = my_date.format(Date())
        val currentMonth = my_month.format(Date())
        val currenYear = my_year.format(Date())
      //  System.out.println(" C DATE is  "+currentDate)



      //  Log.d("TIME_DAY","${currentDate} ${currentMonth} ${currenYear}")
        var date = 1641531600000

        binding.calendarView.setDate(date,true,true)

        return binding.root
    }

    private fun enableButton(etEvent: EditText, etCategory: EditText, btOkEvent: Button){

        //Listen etEvent
        etEvent.doAfterTextChanged { itEvent ->

            if ("$itEvent" !=""){
                etCategory.doAfterTextChanged {itCategory ->
                    btOkEvent.isEnabled = "$itCategory" != ""
                    sendData("${itEvent}","${itCategory}",this.date)
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
                    sendData("${itEvent}","${itCategory}",this.date)
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
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                DataFragment()
            )
        }
    }
}