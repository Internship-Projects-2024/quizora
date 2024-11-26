package com.technovix.quizora

import android.util.Log
import retrofit2.HttpException

class TriviaRepository {
    suspend fun getQuestions(
        amount: Int,
        category: Int,
        difficulty: String
    ) : List<Question> {
        return try {
            val response = RetrofitClient.api.getQuestions(amount, category, difficulty)
            if (response.response_code == 0) {
                Log.d("TriviaRepository", "Successfully fetched questions")
                response.results
            } else {
                Log.e("TriviaRepository", "Error: Response code is ${response.response_code}")
                emptyList()
            }
        } catch (e: HttpException) {
            Log.e("TriviaRepository", "HTTP error: ${e.message}")
            emptyList()
        } catch (e: Exception) {
            Log.e("TriviaRepository", "Error: ${e.localizedMessage}")
            emptyList()
        }
    }
}