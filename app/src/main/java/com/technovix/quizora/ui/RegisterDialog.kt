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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterDialog(
    context: Context,
    onDismiss: () -> Unit
) {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    var nickname by remember { mutableStateOf(TextFieldValue()) }
    var isError by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = { /* Bu ekran kapatılamaz */ },
        title = {
            Text(
                text = "Kullanıcı Adınızı Belirleyin",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Açıklama
                Text(
                    text = "Bu kullanıcı adı liderlik tablosunda görünecektir. Lütfen bir ad giriniz.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )

                // TextField
                OutlinedTextField(
                    value = nickname,
                    onValueChange = {
                        nickname = it
                        isError = it.text.isEmpty()
                    },
                    label = { Text("Nickname") },
                    isError = isError,
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                        errorBorderColor = MaterialTheme.colorScheme.error
                    ),
                    shape = MaterialTheme.shapes.medium
                )

                if (isError) {
                    Text(
                        text = "Lütfen kullanıcı adını boş bırakmayınız!",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (nickname.text.isNotEmpty()) {
                        sharedPreferences.edit().putString("nickname", nickname.text).apply()
                        sharedPreferences.edit().putBoolean("is_first_launch", false).apply()
                        Toast.makeText(context, "Nickname başarıyla kaydedildi!", Toast.LENGTH_LONG).show()
                        onDismiss()
                    } else {
                        isError = true
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("KAYDET")
            }
        },
        containerColor = MaterialTheme.colorScheme.background,
        shape = MaterialTheme.shapes.large
    )
}



@Composable
fun ShowRegisterDialog(onDismiss: () -> Unit) {
    val context = LocalContext.current
    RegisterDialog(context = context, onDismiss = onDismiss)
}

@Preview(showBackground = true)
@Composable
fun RegisterDialogPreview() {
    RegisterDialog(
        context = LocalContext.current,
        onDismiss = {}
    )
}

