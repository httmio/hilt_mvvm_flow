package com.example.hilt_mvvm.main

import kotlinx.coroutines.delay

class MainRepository {

    suspend fun getAnimals(): List<Animal> {
        val lion = Animal("Cat", "Lion")
        val tiger = Animal("Cat", "Tiger")
        val cat = Animal("Cat", "Cat")
        delay(20000)
        return listOf(lion, tiger, cat)
    }
}

