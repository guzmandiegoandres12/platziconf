package com.platzi.conf.view.ui.fracments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.platzi.conf.R
import com.platzi.conf.model.Speaker
import kotlinx.android.synthetic.main.fragment_dpeakers_details_dialoge.*
import kotlinx.android.synthetic.main.item_speaker.*

/**
 * A simple [Fragment] subclass.
 */
class DpeakersDetailsDialogeFracment : DialogFragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL,R.style.dialogstyle)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dpeakers_details_dialoge, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toollboarddetailExpositor.navigationIcon =   ContextCompat.getDrawable(view.context,R.drawable.ic_close_black_24dp)
        toollboarddetailExpositor.setTitleTextColor(Color.WHITE)
        toollboarddetailExpositor.setNavigationOnClickListener{
            dismiss()
        }
        var speaker = arguments?.getSerializable("speaker") as Speaker
        toollboarddetailExpositor.title = speaker.name
        tvExpositorNamedetail.text = speaker.name
        tvExpositorJobDetail.text = speaker.jobtitle
        tvExpositorWorkPlaceDetail.text = speaker.workPlace
        tvExpositorWorkDetail.text = speaker.biografia
        Glide.with(view.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(tvExpositorPhotoDetail)
    }



    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
    }

}
