package com.chandra.suitmediatest.ui.eventmap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.chandra.suitmediatest.data.model.Event
import com.chandra.suitmediatest.databinding.SlideItemContainerBinding

class SliderAdapter(listEvent: MutableList<Event>, viewPager: ViewPager2) :
    RecyclerView.Adapter<SliderAdapter.SlideViewHolder>() {
    inner class SlideViewHolder(val binding: SlideItemContainerBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var listEvent: List<Event> = listEvent

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val binding =
            SlideItemContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SlideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        val event = listEvent[position]
        holder.binding.tvEventSliderName.text = event.name
        Glide.with(holder.itemView.context).load(event.image).into(holder.binding.imageSlide)
    }

    override fun getItemCount(): Int = listEvent.size

}