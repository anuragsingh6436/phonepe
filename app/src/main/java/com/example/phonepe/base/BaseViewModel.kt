package com.example.phonepe.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phonepe.model.Event

abstract class BaseViewModel:ViewModel() {

    val eventStream = MutableLiveData<Event>()

}