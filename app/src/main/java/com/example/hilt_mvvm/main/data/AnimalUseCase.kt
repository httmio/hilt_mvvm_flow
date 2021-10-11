package com.example.hilt_mvvm.main.data

import com.example.hilt_mvvm.main.Animal
import com.example.hilt_mvvm.main.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AnimalUseCase @Inject constructor(
    private val repository: MainRepository
){
    operator fun invoke() : Flow<Resource<List<Animal>>> = flow{
        try {
            emit(Resource.Loading())
            val data = repository.getAnimals()
            emit(Resource.Success(data))
        } catch (exception: Exception) {
            emit(Resource.Error(exception.message ?: "Error Occurred!"))
        }
    }
}