package com.example.hilt_mvvm.main.repository

import com.example.hilt_mvvm.main.Animal

interface IMainRepository {
    suspend fun getAnimals(): List<Animal>
}