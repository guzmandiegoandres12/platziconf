package com.platzi.conf.networks

import java.lang.Exception

interface Callback <T> {

    fun onSuccess( result: T?)

    fun onFailed( exception: Exception)
}