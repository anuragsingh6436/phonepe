package com.example.phonepe.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.phonepe.adapter.AdapterItemTypes
import com.example.phonepe.base.BaseRecyclerItem
import com.example.phonepe.model.Event
import com.example.phonepe.model.response.MovieListV2

class MovieItemViewModel(val data: MovieListV2, val eventStream:MutableLiveData<Event>):
    BaseRecyclerItem {


    fun getTitle():String {
        return data.title
    }

    fun getPosterPath():String {
        return data.poster_path
    }

    override fun getItemType(): Int {
        return AdapterItemTypes.ADAPTER_ITEM_TYPE_1
    }

    fun getRating():String {
        return data.vote_average.toString()
    }

}