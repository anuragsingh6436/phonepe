package com.example.phonepe.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phonepe.viewModel.MainViewModel
import com.example.phonepe.R
import com.example.phonepe.constants.Constants
import com.example.phonepe.custom.VerticalItemDecorator
import com.example.phonepe.databinding.ActivityMainBinding
import com.example.phonepe.event.ActivityEvent
import com.example.phonepe.model.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.viewModel = viewModel

        viewModel.eventStream.observe(this) {
            handleEvents(it)
        }

        addItemDecoration()
    }

    private fun addItemDecoration() {
        with(dataBinding) {
            recyclerView.addItemDecoration(VerticalItemDecorator(20))

        }
    }

    private fun handleEvents(event: Event) {
        when (event.id) {
            ActivityEvent.API_ERROR -> {
                showToastError()
            }
        }
    }

    private fun showToastError() {
        Toast.makeText(this, Constants.API_ERROR_MESSAGE, Toast.LENGTH_LONG).show()
    }

}
