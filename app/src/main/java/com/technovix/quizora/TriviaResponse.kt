package com.technovix.quizora

data class TriviaResponse(
    val response_code: Int,
    var results: List<Question>
)
