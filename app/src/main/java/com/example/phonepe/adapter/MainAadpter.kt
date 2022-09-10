package com.example.phonepe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.phonepe.base.BaseAdapter
import com.example.phonepe.viewModel.MovieItemViewModel
import com.example.phonepe.R
import com.example.phonepe.base.BaseRecyclerItem
import com.example.phonepe.base.BaseViewHolder
import com.example.phonepe.databinding.AdapterItemBinding


class MainAadpter : BaseAdapter() {


    val initialItemsList = ArrayList<MovieItemViewModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<BaseRecyclerItem> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val dataBinding: AdapterItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.adapter_item, parent, false
        )
        return MainViewHolder(dataBinding.root, dataBinding) as BaseViewHolder<BaseRecyclerItem>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseRecyclerItem>, position: Int) {
        holder.onBindData(this.items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MainViewHolder(itemView: View, val dataBinding: AdapterItemBinding) :
        BaseViewHolder<MovieItemViewModel>(itemView) {

        override fun onBindData(item: MovieItemViewModel, position: Int) {
            with(dataBinding) {
                model = item
                executePendingBindings()
            }
        }
    }

}