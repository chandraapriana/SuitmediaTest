package com.chandra.suitmediatest.ui.event

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chandra.suitmediatest.data.model.Event
import com.chandra.suitmediatest.databinding.ItemEventBinding

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    private var listEvent = ArrayList<Event>()
    private var onItemClickCallback: OnItemClickCallback? = null


    inner class EventViewHolder(val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = listEvent[position]
        holder.binding.apply {
            tvEventName.text = event.name
            tvEventDate.text = event.date
            Glide.with(holder.itemView.context).load(event.image).into(imgEvent)
            root.setOnClickListener { onItemClickCallback?.onItemClicked(event) }
        }
    }

    override fun getItemCount(): Int = listEvent.size

    fun setEvent(event: List<Event>) {
        this.listEvent.addAll(event)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(event: Event)
    }
}