package com.example.hilt_mvvm.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hilt_mvvm.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLiveData()
        mainViewModel.getUser2()
    }

    private fun setLiveData() {
        mainViewModel.state.observe(this, {
            run {
                setContent {
                    if (it.isLoading) {
                        ProgressBar(true)
                    } else {
                        ProgressBar(false)
                    }
                    it.animal?.let {
                        AnimalCard(
                            Animal(
                                it.type,
                                it.name
                            )
                        )
                    }
                }
            }
        })
    }
}

data class Animal(val type: String, val name: String)

@Composable
fun AnimalCard(msg: Animal) {
    Column {
        Text(text = msg.type)
        Text(text = msg.name)
    }
}

@Composable
fun ProgressBar(isShow: Boolean) {
    if (isShow) {
        CircularProgressIndicator()
    }
}


@Preview
@Composable
fun PreviewMessageCard() {
    AnimalCard(
        msg = Animal("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
    )
}
