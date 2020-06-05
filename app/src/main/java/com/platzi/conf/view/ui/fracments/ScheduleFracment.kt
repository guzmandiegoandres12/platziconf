package com.platzi.conf.view.ui.fracments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.platzi.conf.R
import com.platzi.conf.model.Conference
import com.platzi.conf.view.adapters.ScheduleAdapter
import com.platzi.conf.view.adapters.Schedulelistener
import com.platzi.conf.viewModel.ScheduleViewModel
import kotlinx.android.synthetic.main.fragment_schedule.*

/**
 * A simple [Fragment] subclass.
 */
class ScheduleFracment : Fragment() , Schedulelistener{
    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var viewModel: ScheduleViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ScheduleViewModel::class.java)
        viewModel.refresh()
        scheduleAdapter = ScheduleAdapter(this)
        rvSchedule.apply {
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
            adapter = scheduleAdapter
        }
       obserViewMOdel()
    }
    fun obserViewMOdel(){

        viewModel.listschedule.observe(this, Observer<List<Conference>> { schedule->scheduleAdapter.updateDate(schedule)})
        viewModel.isLoadin.observe(this, Observer <Boolean> {
            if(it != null)
                rlBaseSchedule.visibility = View.INVISIBLE

        })
    }

    @SuppressLint("ResourceType")
    override fun onConferenceClick(conference: com.platzi.conf.model.Conference, position: Int) {
        val bundle = bundleOf("conference" to conference)
        findNavController().navigate(R.id.ScheduleDetailFragmentDialog,bundle)
    }
}


