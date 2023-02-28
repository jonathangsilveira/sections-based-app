package com.example.jonathan.sectionsapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jonathan.component.ViewHolderComponent
import com.example.jonathan.component.ViewHolderItemEvent
import com.example.jonathan.domain.request.HomeRequest
import com.example.jonathan.sectionsapp.component.HomeItemEvent
import com.example.jonathan.sectionsapp.domain.usecase.GetHomeUseCase
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase
) : ViewModel() {

    private val _stateObserver = MutableLiveData(HomeState())

    val stateObserver: LiveData<HomeState> get() = _stateObserver

    fun refresh() {
        viewModelScope.launch {
            startLoading()
            runCatching { getHomeUseCase(HomeRequest("")) }
                .onSuccess(::onSuccess)
                .onFailure(::onFailure)
        }
    }

    private fun startLoading() {
        updateState { currentState ->
            currentState.copy(
                isLoading = true,
                results = emptyList(),
                error = null
            )
        }
    }

    private fun onSuccess(components: List<ViewHolderComponent>) {
        updateState { currentState ->
            currentState.copy(
                isLoading = false,
                results = components,
                error = null
            )
        }
    }

    private fun onFailure(cause: Throwable) {
        println(cause)
        updateState { currentState ->
            currentState.copy(
                isLoading = false,
                results = emptyList(),
                error = cause.message
            )
        }
    }

    private fun updateState(block: (currentState: HomeState) -> HomeState) {
        _stateObserver.value?.let { currentState ->
            _stateObserver.value = block(currentState)
        }
    }

    fun onItemAction(action: ViewHolderItemEvent) {
        if (action is HomeItemEvent) {
            when (action) {
                HomeItemEvent.ItemClicked -> Log.d("HomeViewModel", "Click event")
                HomeItemEvent.ItemLongClicked -> Log.d("HomeViewModel", "Long click event")
                HomeItemEvent.RemoveItemClicked -> Log.d("HomeViewModel", "Remove click event")
            }
        }
    }
}