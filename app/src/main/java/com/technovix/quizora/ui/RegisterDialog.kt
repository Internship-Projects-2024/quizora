package com.technovix.quizora.ui


import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun RegisterDialog(context: Context, onDismiss: () -> Unit) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    var nickname by remember { mutableStateOf(TextFieldValue()) }

    AlertDialog(
        onDismissRequest = { },
        title = { Text(text = "Kullanıcı nickname'i gir") },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = nickname,
                    onValueChange = { nickname = it },
                    label = { Text(text = "Nickname") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (nickname.text.isNotEmpty()) {
                        sharedPreferences.edit().putBoolean("is_first_launch", false).apply()

                        Toast.makeText(context, "Nickname başarıyla kaydedildi!", Toast.LENGTH_LONG).show()
                        onDismiss() // Dismiss the dialog
                    } else {
                        Toast.makeText(context, "Lütfen boş bırakmayınız", Toast.LENGTH_LONG).show()
                    }
                }
            ) {
                Text("Tamam")
            }
        }
    )
}

@Composable
fun ShowRegisterDialog(onDismiss: () -> Unit) {
    val context = LocalContext.current
    RegisterDialog(context = context, onDismiss = onDismiss)
}
