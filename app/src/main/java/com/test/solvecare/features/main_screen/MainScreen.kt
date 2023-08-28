package com.test.solvecare.features.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
    modifier: Modifier = Modifier,
) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    MainScreenContent(
        state = state.value,
        onTextFieldChange = viewModel::onTextFieldChange,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
private fun MainScreenContent(
    state: MainState,
    onTextFieldChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(state.spaceBetweenBox.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            TextField(
                value = state.textFiledValue,
                onValueChange = onTextFieldChange,
                modifier = Modifier.fillMaxWidth()
            )
        }

        items(
            items = state.boxList,
            key = { it.id }
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(
                        width = it.width.dp,
                        height = it.height.dp
                    )
                    .background(Color(state.boxColor))
            ) {
                // Should be empty?
            }
        }
    }
}