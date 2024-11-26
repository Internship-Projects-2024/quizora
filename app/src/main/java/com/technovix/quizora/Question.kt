package com.technovix.quizora

data class Question(
    val category: String,
    val type: String,
    val difficulty: String,
    val question: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>
) {
    fun getAllAnswers(): List<String> {
        return listOf(correctAnswer) + incorrectAnswers
    }
}
