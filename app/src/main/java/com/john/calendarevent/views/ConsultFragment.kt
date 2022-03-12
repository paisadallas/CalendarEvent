package com.john.calendarevent.views

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.navigation.fragment.findNavController
import com.john.calendarevent.MainActivity
import com.john.calendarevent.R
import com.john.calendarevent.adapter.EventAdapterListener
import com.john.calendarevent.data.Data
import com.john.calendarevent.databinding.FragmentConsultBinding
import java.text.SimpleDateFormat
import java.util.*


private const val ARG_PARAM1 = "param1"

class ConsultFragment : Fragment() {

    private val formatter = SimpleDateFormat("dd/MM/yyyy")
    private var date: String = formatter.format(Date())

    private var param1: String? = null
    lateinit var eventAdapterListener:EventAdapterListener
    private val binding by lazy {
        FragmentConsultBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        eventAdapterListener = activity as EventAdapterListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var  deleteItem:Int =0
        for (i in 0 until (Data.listEvent.size )){
            if (Data.listEvent[i].id.equals(param1)){
                Log.d("CONSULT_FRAGMENT_TITLE","${Data.listEvent[i].title}")
                binding.tvTitle.text= Data.listEvent[i].title
                binding.tvCategory.text = Data.listEvent[i].category
                binding.tvItemCalendar.text = Data.listEvent[i].calendar
                deleteItem = i
            }

        }

        binding.btDelete.setOnClickListener {
            Data.listEvent.removeAt(deleteItem)
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                DataFragment()
            )
        }


        return binding.root
    }

    fun remainingDays(today:String, evendDay:String): String{

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            ConsultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }
}