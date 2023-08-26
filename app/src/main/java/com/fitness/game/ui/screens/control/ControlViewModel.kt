package com.fitness.game.ui.screens.control

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fitness.game.domain.ControlRepository
import com.fitness.game.domain.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ControlViewModel : ViewModel() {
    private val repository = ControlRepository()
    private val _list = MutableLiveData<List<Product>>(emptyList())
    val list: LiveData<List<Product>> = _list

    fun getList() {
        viewModelScope.launch {
            _list.postValue(repository.getProducts())
        }
    }

    fun addProduct(name: String, calories: Int) {
        viewModelScope.launch {
            repository.addProduct(Product(0, name, calories))
            delay(10)
            _list.postValue(repository.getProducts())
        }
    }

    fun deleteProduct(id: Int) {
        viewModelScope.launch {
            repository.deleteProduct(id)
            delay(10)
            _list.postValue(repository.getProducts())
        }
    }
}