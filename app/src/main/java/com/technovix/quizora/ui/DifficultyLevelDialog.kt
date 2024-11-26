package com.technovix.quizora.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.technovix.quizora.DifficultyButton

@Composable
fun DifficultyLevelDialog(
    onDismiss: () -> Unit,
    onSelectLevel: (String) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Select Difficulty Level",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF125BDB)
                )
                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close dialog",
                        tint = Color.Gray
                    )
                }
            }
        },
        text = {
            Text(
                text = "Choose the difficulty level to begin the quiz.",
                fontSize = 16.sp,
                color = Color.Gray
            )
        },
        confirmButton = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Easy Button
                DifficultyButton(
                    text = "Easy",
                    buttonColor = Color(0xFF81C784),
                    textColor = Color.White,
                    onClick = { onSelectLevel("Easy") }
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Medium Button
                DifficultyButton(
                    text = "Medium",
                    buttonColor = Color(0xFFFFD54F), // Yellow
                    textColor = Color.White,
                    onClick = { onSelectLevel("Medium") }
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Hard Button
                DifficultyButton(
                    text = "Hard",
                    buttonColor = Color(0xFFE57373), // Red
                    textColor = Color.White,
                    onClick = { onSelectLevel("Hard") }
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Mixed Button
                DifficultyButton(
                    text = "Mixed",
                    buttonColor = Color(0xFF64B5F6), // Blue
                    textColor = Color.White,
                    onClick = { onSelectLevel("Mixed") }
                )
            }
        },
        dismissButton = {}
    )
}

