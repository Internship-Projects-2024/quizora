package com.technovix.quizora.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technovix.quizora.data.model.Question
import com.technovix.quizora.data.repository.TriviaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TriviaViewModel(private val repository: TriviaRepository): ViewModel() {

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun loadQuestions(amount: Int, category: Int?, difficulty: String?, type: String?) {
        viewModelScope.launch {
            try {
                val response = repository.fetchQuestion(amount, category, difficulty, type)
                _questions.value = response.results
            } catch (e: Exception) {
                _errorMessage.value = "Error fetching questions: ${e.message}"
            }
        }
    }
}