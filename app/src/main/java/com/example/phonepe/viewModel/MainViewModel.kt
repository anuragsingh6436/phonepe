package com.example.phonepe.viewModel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phonepe.adapter.MainAadpter
import com.example.phonepe.base.BaseRecyclerItem
import com.example.phonepe.base.BaseViewModel
import com.example.phonepe.event.ActivityEvent
import com.example.phonepe.helper.MainViewModelRecyclerHelper
import com.example.phonepe.model.Event
import com.example.phonepe.model.response.MovieList
import com.example.phonepe.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


const val api_key = "80487b92e163261cd7ad5a26b48af717"

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val recyclerHelper: MainViewModelRecyclerHelper
) : BaseViewModel() {

    val adapter = MainAadpter()
    val itemsList = ObservableArrayList<BaseRecyclerItem>()
    var movieList: MovieList? = null
    val playListIconVisibility = ObservableBoolean(true)
    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            mainRepository.getUsers(api_key)
                .catch {
                    eventStream.postValue(Event(ActivityEvent.API_ERROR))
                }
                .collect {
                    movieList = it
                    val recyclerItems = recyclerHelper.getRecyclerItems(it, eventStream)
                    itemsList.addAll(recyclerItems)
                    adapter.initialItemsList.addAll(recyclerItems)
                }
        }
    }

    fun openPlayListFragment() {
        playListIconVisibility.set(!playListIconVisibility.get())
        eventStream.postValue(Event(ActivityEvent.OPEN_PLAYLIST_FRAGMENT))
    }

}


