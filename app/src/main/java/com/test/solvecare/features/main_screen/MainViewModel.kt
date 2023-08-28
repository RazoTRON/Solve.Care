package com.test.solvecare.features.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.solvecare.di.FakeDi
import com.test.solvecare.domain.GetRepositoryUseCase
import com.test.solvecare.domain.model.Box
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

data class MainState(
    val textFiledValue: String = "",
    val spaceBetweenBox: Int = 0,
    val boxColor: Long = 0xFFFF,
    val boxList: List<Box> = listOf(),
)

@OptIn(FlowPreview::class)
class MainViewModel(
    private val getRepositoryUseCase: GetRepositoryUseCase = FakeDi.getRepositoryUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        @OptIn(FlowPreview::class)
        state.apply {
            viewModelScope.launch {
                shareIn(viewModelScope, SharingStarted.Lazily)
                    .debounce(500)
                    .collect { state -> getBoxes(state.textFiledValue) }
            }
        }
    }

    fun onTextFieldChange(value: String) {
        viewModelScope.launch {
            _state.emit(state.value.copy(textFiledValue = value))
        }
    }

    private fun getBoxes(path: String) {
        viewModelScope.launch {
            val result = getRepositoryUseCase.execute(path)

            _state.emit(
                state.value.copy(
                    spaceBetweenBox = result.spaceBetweenBox,
                    boxColor = result.boxColor,
                    boxList = result.boxes
                )
            )
        }
    }
}
