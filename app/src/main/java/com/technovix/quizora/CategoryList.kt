package com.technovix.quizora


import androidx.compose.ui.graphics.Color
import com.technovix.quizora.CategoryItem

val categoryList = listOf(
    CategoryItem(
        title = "Mathematics",
        description = "Improve your math skills!",
        backgroundColor = Color(0xFF2196F3)
    ),
    CategoryItem(
        title = "Science",
        description = "Explore the wonders of science!",
        backgroundColor = Color(0xFF4CAF50)
    ),
    CategoryItem(
        title = "History",
        description = "Learn about historical events!",
        backgroundColor = Color(0xFFFF9800)
    ),
    CategoryItem(
        title = "Art",
        description = "Express yourself through art!",
        backgroundColor = Color(0xFF9C27B0)
    )
)
