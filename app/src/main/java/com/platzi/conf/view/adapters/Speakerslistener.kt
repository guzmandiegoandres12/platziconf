package com.platzi.conf.view.adapters

import com.platzi.conf.model.Speaker

interface Speakerslistener {
    fun onConferenceClick(speaker: Speaker, position : Int)
}