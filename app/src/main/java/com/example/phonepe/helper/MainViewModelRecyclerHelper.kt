package com.example.phonepe.helper

import androidx.lifecycle.MutableLiveData
import com.example.phonepe.viewModel.MovieItemViewModel
import com.example.phonepe.model.Event
import com.example.phonepe.model.response.MovieList
import javax.inject.Inject

class MainViewModelRecyclerHelper @Inject constructor(){

    fun getRecyclerItems(response: MovieList, eventStream: MutableLiveData<Event>):List<MovieItemViewModel> {
        val data = ArrayList<MovieItemViewModel>()
        response.results.forEach {
            data.add(MovieItemViewModel(it,eventStream))
        }
        return data
    }
}