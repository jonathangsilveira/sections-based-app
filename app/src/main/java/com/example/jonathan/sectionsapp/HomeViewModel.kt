package com.example.jonathan.sectionsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jonathan.component.Command
import com.example.jonathan.component.ViewHolderItem
import com.example.jonathan.domain.request.HomeRequest
import com.example.jonathan.sectionsapp.component.HomeCommandReceiver
import com.example.jonathan.sectionsapp.domain.usecase.GetHomeUseCase
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase
) : ViewModel() {

    private val _stateObserver = MutableLiveData(HomeState())
    val stateObserver: LiveData<HomeState> get() = _stateObserver

    private val commandReceiver = object : HomeCommandReceiver {
        override fun navigateToDetails(id: Long) {
            println("Command to navigate to details has been received!")
        }
    }

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

    private fun onSuccess(components: List<ViewHolderItem<HomeCommandReceiver>>) {
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

    fun processCommand(command: Command<HomeCommandReceiver>) {
        command.execute(commandReceiver)
    }
}