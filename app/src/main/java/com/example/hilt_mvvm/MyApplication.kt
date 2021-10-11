package com.example.hilt_mvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


//用Annotation @HiltAndroidApp 來指定這個Application Class需要Hilt
@HiltAndroidApp
class MyApplication : Application() {


}