package com.platzi.conf.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.conf.networks.Callback
import com.platzi.conf.networks.FirestoreServer
import com.platzi.conf.model.Speaker
import java.lang.Exception

class SpeakersViewModel: ViewModel() {
    val firebaseFirestore= FirestoreServer()
    val  listspeakers: MutableLiveData<List<Speaker>> = MutableLiveData()
    val isLoadin = MutableLiveData<Boolean>()

    fun refresh(){
        getSchedulefromFirebase()
    }
    fun getSchedulefromFirebase(){
        firebaseFirestore.getSpeakers( object: Callback<List<Speaker>> {
            override fun onFailed(exception: Exception) {
                processFinished()
            }

            override fun onSuccess(result: List<Speaker>?) {
                listspeakers.postValue(result)
                processFinished()
            }

        })
    }
    fun processFinished(){
        isLoadin.value=true
    }
}