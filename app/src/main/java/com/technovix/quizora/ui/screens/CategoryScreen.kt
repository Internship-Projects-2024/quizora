package com.technovix.quizora.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.technovix.quizora.ui.Category
import com.technovix.quizora.ui.CategoryItem
import java.lang.reflect.Modifier

@Composable
fun CategoryScreen() {
    val categories = listOf(
        Category(1, "Bilim"),
        Category(2, "Sanat"),
        Category(3, "Spor"),
        Category(4, "Teknoloji"),
        Category(5, "Tarih")
    )

    Box {
        Text(text = "category")
    }
}
