package com.platzi.conf.view.ui.fracments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.platzi.conf.R
import com.platzi.conf.model.Conference
import com.platzi.conf.model.Speaker
import com.platzi.conf.view.adapters.SpeakersAdapter
import com.platzi.conf.view.adapters.Speakerslistener
import com.platzi.conf.viewModel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.fragment_spekears.*

/**
 * A simple [Fragment] subclass.
 */
class SpekearsFracment : Fragment() , Speakerslistener  {
    private lateinit var speakerAdapter : SpeakersAdapter
    private lateinit var viewModel : SpeakersViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spekears, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProviders.of(this).get(SpeakersViewModel::class.java)
        viewModel.refresh()
        speakerAdapter = SpeakersAdapter(this)
        rvSpeakers.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter =  speakerAdapter
        }
        obserViewMOdel()
    }
    fun obserViewMOdel(){

        viewModel.listspeakers.observe(this, Observer<List<Speaker>> { schedule->speakerAdapter.updateDate(schedule)})
        viewModel.isLoadin.observe(this, Observer <Boolean> {
            if(it != null)
                rlBasespeaker.visibility = View.INVISIBLE

        })
    }

    @SuppressLint("ResourceType")
    override fun onConferenceClick(speaker: Speaker, position: Int) {
        val bundle = bundleOf("speaker" to speaker)
        findNavController().navigate(R.id.speakersDetailFragmentDialog,bundle)
    }

}
