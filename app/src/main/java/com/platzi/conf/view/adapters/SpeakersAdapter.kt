package com.platzi.conf.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.platzi.conf.R
import com.platzi.conf.model.Speaker

class SpeakersAdapter(val speakerListener: Speakerslistener ): RecyclerView.Adapter<SpeakersAdapter.ViewHolder>()  {
    var listSpeakers = ArrayList<Speaker>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SpeakersAdapter.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_speaker, parent, false
        )
    )
    override fun getItemCount() = listSpeakers.size

    override fun onBindViewHolder(holder: SpeakersAdapter.ViewHolder, position: Int) {
        val speakers =  listSpeakers [position] as Speaker
        holder.ExpositorJob.text = speakers.jobtitle
        holder.ExpositorName.text = speakers.name
        Glide.with(holder.itemView.context)
            .load(speakers.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ExpositorPhoto)
        holder.itemView.setOnClickListener {
            speakerListener.onConferenceClick(speakers,position)
        }

    }
    fun updateDate(data:List<Speaker>){
        listSpeakers.clear()
        listSpeakers.addAll(data)
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val  ExpositorJob = itemView.findViewById<TextView>(R.id.tvItemExpositorWork)
        val  ExpositorName = itemView.findViewById<TextView>(R.id.tvItemExpositorName)
        val  ExpositorPhoto = itemView.findViewById<ImageView>(R.id.ivItemExpositorPhoto)

    }

}