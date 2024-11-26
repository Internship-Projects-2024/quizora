package com.technovix.quizora.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.technovix.quizora.CategoryItem

data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswer: String
)

@Composable
fun QuestionsScreen(
    category: CategoryItem,
    difficultyLevel: String
) {
    val questions = getQuestionsForCategoryAndLevel(category, difficultyLevel)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Category: ${category.title} - Difficulty: $difficultyLevel",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        questions.forEachIndexed { index, question ->
            Text(text = "${index + 1}. ${question.questionText}")
            question.options.forEach { option ->
                Text(text = " - $option")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

fun getQuestionsForCategoryAndLevel(category: CategoryItem, difficultyLevel: String): List<Question> {
    // Bu fonksiyon, kategoriye ve zorluk seviyesine göre soruları döndürecek.
    return when (difficultyLevel) {
        "Easy" -> listOf(
            Question("What is 2 + 2?", listOf("3", "4", "5", "6"), "4"),
            Question("What is the capital of France?", listOf("Berlin", "Madrid", "Paris", "London"), "Paris")
        )
        "Medium" -> listOf(
            Question("Who invented the telephone?", listOf("Einstein", "Bell", "Newton", "Tesla"), "Bell"),
            Question("Which planet is known as the Red Planet?", listOf("Mars", "Earth", "Venus", "Jupiter"), "Mars")
        )
        "Hard" -> listOf(
            Question("What is the square root of 256?", listOf("12", "14", "16", "18"), "16"),
            Question("What is the atomic number of Gold?", listOf("79", "80", "77", "76"), "79")
        )
        "Mixed" -> listOf(
            Question("What is 5 + 5?", listOf("10", "11", "12", "13"), "10"),
            Question("Who painted the Mona Lisa?", listOf("Da Vinci", "Van Gogh", "Picasso", "Rembrandt"), "Da Vinci")
        )
        else -> emptyList()
    }
}
