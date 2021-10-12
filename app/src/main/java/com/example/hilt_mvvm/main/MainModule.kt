package com.example.hilt_mvvm.main

import com.example.hilt_mvvm.main.repository.IMainRepository
import com.example.hilt_mvvm.main.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
object MainModule {
    @Provides
    fun provideMainRepository() : IMainRepository {
        return MainRepository()
    }
}