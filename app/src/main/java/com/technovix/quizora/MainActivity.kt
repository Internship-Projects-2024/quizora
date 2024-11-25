package com.technovix.quizora

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModelProvider
import com.technovix.quizora.ui.Category
import com.technovix.quizora.ui.CategoryList
import com.technovix.quizora.ui.ShowRegisterDialog
import com.technovix.quizora.ui.screens.MainScreen
import com.technovix.quizora.ui.theme.QuizoraTheme
import com.technovix.quizora.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContent {
            QuizoraTheme {
                MainScreen(context = LocalContext.current)
            }
        }
    }
}

