package com.technovix.quizora.data.repository

import com.technovix.quizora.data.model.TriviaResponse
import com.technovix.quizora.data.network.RetrofitClient
import com.technovix.quizora.ui.Category

class TriviaRepository {
    suspend fun fetchQuestion(amount: Int, category: Int?, difficulty: String?, type: String?): TriviaResponse {
        return RetrofitClient.apiService.getQuestions(amount, category, difficulty, type)
    }
}