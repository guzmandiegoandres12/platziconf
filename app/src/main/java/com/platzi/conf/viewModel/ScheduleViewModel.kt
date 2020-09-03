package com.platzi.conf.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.conf.networks.Callback
import com.platzi.conf.networks.FirestoreServer
import com.platzi.conf.model.Conference
import java.lang.Exception

class ScheduleViewModel: ViewModel() {
    val firebaseFirestore=FirestoreServer()
    val  listschedule: MutableLiveData <List<Conference>> = MutableLiveData()
    val isLoadin = MutableLiveData<Boolean>()

    fun refresh(){
        getSchedulefromFirebase()
    }
    fun getSchedulefromFirebase(){
        firebaseFirestore.getSchudele( object: Callback <List<Conference>> {
            override fun onSuccess(result: List<Conference>?) {
                listschedule.postValue(result)
                processFinished()
                Log.e("sussess","eprocceso exitos")
            }

            override fun onFailed(exception: Exception) {
                processFinished()
                Log.e("norExis","eprocceso  no exitos")
            }

        })
    }
    fun processFinished(){
        isLoadin.value=true
    }
}