package com.platzi.conf.networks

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.platzi.conf.model.Conference
import com.platzi.conf.model.Speaker

class FirestoreServer {
    val firebaseFirestore =  FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    val  CONFERENCES = "Conferences"
    val SPEAKERS = "Speakers"
    init{
        firebaseFirestore.firestoreSettings = settings
    }
    fun getSpeakers(callback: Callback<List<Speaker>>){
        firebaseFirestore.collection( SPEAKERS)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for ( doc in result){
                    var list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getSchudele(callback: Callback <List<Conference>>){
        firebaseFirestore.collection(CONFERENCES)
            .get()
            .addOnSuccessListener { result ->
                for ( doc in result){
                    var list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
            . addOnFailureListener { exception ->
            Log.w("Salida", "Error getting documents.", exception)
        }
    }
}