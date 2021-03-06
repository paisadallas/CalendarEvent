package com.john.calendarevent.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.john.calendarevent.R
import com.john.calendarevent.data.Data
import com.john.calendarevent.model.Event


class EventAdapter (
    private val eventAdapterListener: EventAdapterListener,
    private val eventList:MutableList<Event> = mutableListOf()

        ): RecyclerView.Adapter<EventViewHolder>() {

    fun updateEventData(event: Event){
        eventList.add(0,event)

        notifyItemInserted(0)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val eventView = LayoutInflater.from(parent.context).inflate(R.layout.event_item,parent,false)
        return EventViewHolder(eventView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.itemView.setOnClickListener {

            eventAdapterListener.onFragmentCliked("${event.id}")

        }
        holder.bind(event)
    }

    override fun getItemCount(): Int = eventList.size

}

class EventViewHolder (intentView: View): RecyclerView.ViewHolder(intentView){

    private val title : TextView = intentView.findViewById(R.id.tv_item_event)
    private val category :TextView = intentView.findViewById(R.id.tv_item_category)
    private val calendary : TextView = intentView.findViewById(R.id.tv_item_calendar)
    private var id : String? =""
    fun bind(event:Event){
        title.text = event.title
        category.text = event.category
        calendary.text = event.calendar
        id=""
    }


}