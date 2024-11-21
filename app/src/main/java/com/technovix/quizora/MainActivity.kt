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
import com.technovix.quizora.ui.Category
import com.technovix.quizora.ui.CategoryList
import com.technovix.quizora.ui.ShowRegisterDialog
import com.technovix.quizora.ui.theme.QuizoraTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizoraTheme {
                MainScreen(context = LocalContext.current)
            }
        }
    }
}

@Composable
fun MainScreen(context: Context) {
    val sharedPreferences = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    // Kullanıcının nickname bilgisi ve ilk açılış durumu kontrol ediliyor
    val nickname = sharedPreferences.getString("nickname", null)
    val isFirstLaunch = sharedPreferences.getBoolean("is_first_launch", true)

    // showDialog durumu, nickname'e bağlı olarak belirleniyor
    var showDialog by remember { mutableStateOf(isFirstLaunch || nickname.isNullOrEmpty()) }

    // Kategori listesi
    val categories = listOf(
        Category(1, "Bilim"),
        Category(2, "Sanat"),
        Category(3, "Spor"),
        Category(4, "Teknoloji"),
        Category(5, "Tarih")
    )

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (showDialog) {
                // Kayıt diyalogu gösteriliyor
                ShowRegisterDialog(
                    onDismiss = { nicknameInput ->
                        // Kullanıcının nickname'i kayıt ediliyor ve dialog kapatılıyor
                        sharedPreferences.edit().putString("nickname", nicknameInput).apply()
                        sharedPreferences.edit().putBoolean("is_first_launch", false).apply()
                        showDialog = false
                    }
                )
            } else {
                // Kullanıcıya hoş geldiniz mesajı ve kategori listesi gösteriliyor
                Text(text = "Hoş Geldiniz, ${nickname.orEmpty()}!")
                CategoryList(categories = categories)
            }
        }
    }
}

@Composable
fun ShowRegisterDialog(onDismiss: (nickname: String) -> Unit) {
    var nickname by remember { mutableStateOf("") }

    // Bir diyalog kutusu, kullanıcıdan nickname alır
    Dialog(onDismissRequest = { /* Kapatma işlemi */ }) {
        Column {
            Text(text = "Lütfen bir kullanıcı adı girin:")
            TextField(
                value = nickname,
                onValueChange = { nickname = it },
                label = { Text("Kullanıcı Adı") }
            )
            Button(onClick = {
                if (nickname.isNotEmpty()) {
                    onDismiss(nickname)
                }
            }) {
                Text("Kaydet")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuizoraTheme {
        MainScreen(context = LocalContext.current)
    }
}
