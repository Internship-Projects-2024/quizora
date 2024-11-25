package com.technovix.quizora.ui.screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.technovix.quizora.ui.ShowRegisterDialog


@Composable
fun MainScreen(context: Context) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
    val nickname = sharedPreferences.getString("nickname", null)
    val isFirstLaunch = sharedPreferences.getBoolean("is_first_launch", true)

    var showDialog by remember { mutableStateOf(isFirstLaunch || nickname.isNullOrEmpty()) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            if(showDialog) {
                ShowRegisterDialog(onDismiss = {
                    showDialog = false
                })
            } else {
                Text(text = "Hoş Geldiniz, ${nickname}!")
            }
        }
    }
}

@Composable
fun MainScreenPreview() {
    MainScreen(context = LocalContext.current)
}