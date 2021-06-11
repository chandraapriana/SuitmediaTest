package com.chandra.suitmediatest.ui.guestevent.guest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chandra.suitmediatest.data.model.Guest
import com.chandra.suitmediatest.databinding.ItemGuestBinding

class GuestAdapter: RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    private var listGuest = ArrayList<Guest>()

    private var onItemClickCallback: OnItemClickCallback? = null

   inner class GuestViewHolder(val binding:ItemGuestBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val binding = ItemGuestBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GuestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        val guest = listGuest[position]
        holder.binding.apply {
            tvName.text = guest.name
            Glide.with(holder.itemView.context).load(guest.image).into(imgGuest)
            root.setOnClickListener { onItemClickCallback?.onItemClicked(guest) }
        }
    }

    override fun getItemCount(): Int =listGuest.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setGuest(guest: List<Guest>) {
        this.listGuest.addAll(guest)
    }

    interface OnItemClickCallback {
        fun onItemClicked(guest: Guest)
    }
}