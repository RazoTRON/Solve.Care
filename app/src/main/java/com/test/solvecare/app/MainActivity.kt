package com.test.solvecare.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.test.solvecare.core_ui.theme.SolveCareTheme
import com.test.solvecare.features.main_screen.MainScreen
import com.test.solvecare.features.top_bar.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolveCareTheme {
                Scaffold(
                    topBar = { TopBar(text = "Title") }
                ) {
                    MainScreen(modifier = Modifier.padding(it))
                }
            }
        }
    }
}