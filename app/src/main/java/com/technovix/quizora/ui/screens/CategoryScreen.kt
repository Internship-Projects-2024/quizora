package com.technovix.quizora.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.technovix.quizora.CategoryCard
import com.technovix.quizora.CategoryItem

@Composable
fun CategoryScreen(
    categories: List<CategoryItem>,
    onCategoryClick: (CategoryItem) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp)
    ) {
        items(categories.size) { index ->
            val category = categories[index]
            CategoryCard(category = category, onClick = onCategoryClick)
        }
    }
}
