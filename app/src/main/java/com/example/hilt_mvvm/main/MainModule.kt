package com.example.hilt_mvvm.main

import com.example.hilt_mvvm.MyApplication_HiltComponents
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
object MainModule {
    @Provides
    fun provideMainRepository() : MainRepository{
        return MainRepository()
    }
}