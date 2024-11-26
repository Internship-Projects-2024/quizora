package com.technovix.quizora

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TriviaViewModel : ViewModel() {
    private val triviaRepository = TriviaRepository()

    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> get() = _questions

    fun fetchQuestions(amount: Int, category: Int, difficulty: String) {
        viewModelScope.launch {
            val fetchedQuestions = triviaRepository.getQuestions(amount, category, difficulty)
            _questions.value = fetchedQuestions
        }
    }
}