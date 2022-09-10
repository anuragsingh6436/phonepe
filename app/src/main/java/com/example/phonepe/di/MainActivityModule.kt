package com.example.phonepe.di

import com.example.phonepe.Network.ApiHelper
import com.example.phonepe.Network.RetrofitBuilder
import com.example.phonepe.helper.MainViewModelRecyclerHelper
import com.example.phonepe.repository.MainRepository
import com.example.phonepe.repository.MainRepositoryImpl
import com.example.phonepe.viewModel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
open class MainActivityModule {

    @Provides
    fun provideMainActivityViewModel(
        repository: MainRepository,
        helper: MainViewModelRecyclerHelper
    ): MainViewModel {
        return MainViewModel(repository, helper)
    }

    @Provides
    fun provideRepository(): MainRepository {
        return MainRepositoryImpl(ApiHelper(apiService = RetrofitBuilder.apiService))
    }
}