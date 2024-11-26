package com.technovix.quizora.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.technovix.quizora.CategoryCard
import com.technovix.quizora.CategoryItem
import com.technovix.quizora.ui.DifficultyLevelDialog

@Composable
fun CategoryScreen(
    categories: List<CategoryItem>,
    onCategoryClick: (CategoryItem, String) -> Unit
) {
    val openDialog = remember { mutableStateOf(false) }
    val selectedCategory = remember { mutableStateOf<CategoryItem?>(null) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp)
    ) {
        items(categories.size) { index ->
            val category = categories[index]
            CategoryCard(category = category) {
                selectedCategory.value = category
                openDialog.value = true
            }
        }
    }

    // Zorluk Seviyesi Seçim AlertDialog
    if (openDialog.value) {
        DifficultyLevelDialog(
            onDismiss = { openDialog.value = false },
            onSelectLevel = { level ->
                selectedCategory.value?.let { category ->
                    onCategoryClick(category, level)
                }
                openDialog.value = false
            }
        )
    }
}


