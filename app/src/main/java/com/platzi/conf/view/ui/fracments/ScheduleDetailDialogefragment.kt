package com.platzi.conf.view.ui.fracments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment

import com.platzi.conf.R
import com.platzi.conf.model.Conference
import kotlinx.android.synthetic.main.fragment_schedule_detail_dialoge.*
import java.text.SimpleDateFormat

/**
 * A simple [Fragment] subclass.
 */
class ScheduleDetailDialogefragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL,R.style.dialogstyle)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule_detail_dialoge, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tbToolbarConferenceDetail.navigationIcon = ContextCompat.getDrawable(view.context,R.drawable.ic_close_black_24dp)
        tbToolbarConferenceDetail.setTitleTextColor(Color.WHITE)
        tbToolbarConferenceDetail.setNavigationOnClickListener{
            dismiss()
        }
        var conference = arguments?.getSerializable("conference")  as Conference
        tbToolbarConferenceDetail.title = conference.title
        tvDetailConferenceName.text = conference.title
        cwdetailConfencespeker.text = conference.speaker
        cwdetailConfenceTag.text =  conference.tag
        cwdetailConfenceDescription.text = conference.description
        val format = SimpleDateFormat("dd/MM/yyyy hh:mm a")
        cwdetailConfenceHour.text = format.format(conference.datataime)

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }
}
