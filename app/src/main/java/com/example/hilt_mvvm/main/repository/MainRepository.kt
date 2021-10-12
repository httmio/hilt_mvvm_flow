package com.example.hilt_mvvm.main.repository

import com.example.hilt_mvvm.main.Animal
import kotlinx.coroutines.delay

class MainRepository : IMainRepository{

    override suspend fun getAnimals(): List<Animal> {
        val lion = Animal("Cat", "Lion")
        val tiger = Animal("Cat", "Tiger")
        val cat = Animal("Cat", "Cat")
        delay(20000)
        return listOf(lion, tiger, cat)
    }
}

