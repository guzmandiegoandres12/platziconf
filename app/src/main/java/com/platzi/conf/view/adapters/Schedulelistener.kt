package com.platzi.conf.view.adapters

import com.platzi.conf.model.Conference

interface Schedulelistener {
    fun onConferenceClick(conference: Conference, position : Int)
}