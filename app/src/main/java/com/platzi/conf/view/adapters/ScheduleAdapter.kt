package com.platzi.conf.view.adapters
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.conf.R
import com.platzi.conf.model.Conference
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAdapter(val schedulelistener: Schedulelistener): RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    var listconferences = ArrayList<Conference>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_schedule,parent,false))

    override fun getItemCount() = listconferences.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val conference =  listconferences [position] as Conference


        try {
         //   holder.conferencespeaker.text = con.speaker
            holder.conferenceName.text= conference.title
            holder.conferenceTag.text = conference.tag
            holder.conferencespeaker.text = conference.speaker
            val simpleDateformat = SimpleDateFormat("HH:mm")
            val simpleDateformatAMPM = SimpleDateFormat("a")

            val cal = Calendar.getInstance()
            cal.time = conference.datataime
            Log.e("time",conference.datataime.toString())
            val hourFormat = simpleDateformat.format(conference.datataime)
            Log.e("time",hourFormat)
            holder.conferenceHouer.text = hourFormat
            holder.conferenceAMPM.text = simpleDateformatAMPM.format(conference.datataime).toUpperCase()
            holder.itemView.setOnClickListener {
                schedulelistener.onConferenceClick(conference,position)
            }
        }
        catch (e: Exception) {
            Log.e("validacion", "aqio llego",e)
        }

    /**
        */
    }
    fun updateDate(data:List<Conference>){
        listconferences.clear()
        listconferences.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val  conferenceName = itemView.findViewById<TextView>(R.id.itemScheduleConferenceName)
        val  conferencespeaker = itemView.findViewById<TextView>(R.id.itemScheduleConferenceSpeaker)
        val  conferenceTag = itemView.findViewById<TextView>(R.id.itemScheduledeTag)
        val  conferenceAMPM = itemView.findViewById<TextView>(R.id.itemScheduleAMPM)
        val  conferenceHouer = itemView.findViewById<TextView>(R.id.itemScheduleHour)
    }

}


