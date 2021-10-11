package com.example.hilt_mvvm.main.data

import com.example.hilt_mvvm.main.Animal

data class AnimalState(
    val isLoading: Boolean = false,
    val animal: Animal? = null,
    val error: String = ""
)