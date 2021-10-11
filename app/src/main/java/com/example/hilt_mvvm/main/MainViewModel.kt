package com.example.hilt_mvvm.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt_mvvm.main.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAnimalUseCase: AnimalUseCase,
    private var mainRepository: MainRepository
) : ViewModel() {

    private var _state = MutableLiveData<AnimalState>()
    val state: LiveData<AnimalState> get() = _state

    fun getUser() {
        getAnimalUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AnimalState(isLoading = false, animal = result.data?.get(0))
                    getUser2()
                }
                is Resource.Error -> {
                    _state.value = AnimalState(error = result.message ?: "Unknown Message")

                }
                is Resource.Loading -> {
                    _state.value = AnimalState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

     fun getUser2() {
        fetchUsers2().onEach { result ->
            when (result.status) {
                Status.SUCCESS -> {
                    _state.value = AnimalState(isLoading = false, animal = result.data?.get(0))
                }
                Status.LOADING -> {
                    _state.value = AnimalState(isLoading = true)
                }
                Status.ERROR -> {
                    _state.value = AnimalState(error = result.message ?: "Unknown Message")
                }
            }
        }
    }
    private fun fetchUsers2() = flow {
        try {
            emit(Resource2.loading(null))
            val data = mainRepository.getAnimals()
            emit(Resource2.success(data))
        } catch (exception: Exception) {
            emit(Resource2.error(exception.message ?: "Error Occurred!", data = null))
        }
    }
}