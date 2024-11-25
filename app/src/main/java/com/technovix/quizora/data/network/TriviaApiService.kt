package com.technovix.quizora.data.network

import com.technovix.quizora.data.model.TriviaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApiService {
    @GET("api.php")
    suspend fun getQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: Int?,
        @Query("difficulty") difficulty: String?,
        @Query("type") type: String?
    ): TriviaResponse
}