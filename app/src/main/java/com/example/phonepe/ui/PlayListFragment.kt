package com.example.phonepe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.phonepe.R
import com.example.phonepe.databinding.PlaylistFragmentBinding
import com.example.phonepe.event.ActivityEvent
import com.example.phonepe.model.Event
import com.example.phonepe.viewModel.MainViewModel
import com.example.phonepe.viewModel.PlayListViewModel


class PlayListFragment : Fragment() {

    val viewModel: PlayListViewModel by viewModels()
    lateinit var dataBinding: PlaylistFragmentBinding

    private val activityViewModel by lazy { activityViewModels<MainViewModel>() }

    companion object {
        const val TAG = "PlayListFragment"
        fun getInstance(): PlayListFragment {
            return PlayListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.playlist_fragment, container, false)
        dataBinding.viewModel = viewModel
        viewModel.eventStream.observe(viewLifecycleOwner) {
            handleEvents(it)
        }

        return dataBinding.root
    }

    private fun handleEvents(event: Event) {
        when (event.id) {
            ActivityEvent.CLOSE_PALYLIST_FRAGMENT -> {
                (activity as FragmentActivity).supportFragmentManager.popBackStack()
            }
        }
    }

}