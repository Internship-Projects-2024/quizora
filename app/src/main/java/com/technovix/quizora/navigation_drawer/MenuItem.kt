package com.technovix.quizora.navigation_drawer

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: ImageVector
)
