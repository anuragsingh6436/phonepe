package com.example.phonepe.viewModel

import com.example.phonepe.base.BaseViewModel
import com.example.phonepe.event.ActivityEvent
import com.example.phonepe.model.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayListViewModel @Inject constructor() : BaseViewModel() {

    fun clickOnEmptyArea() {
        eventStream.postValue(Event(ActivityEvent.CLOSE_PALYLIST_FRAGMENT))
    }

}