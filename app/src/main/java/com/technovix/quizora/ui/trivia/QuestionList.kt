package com.technovix.quizora.ui.trivia

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.technovix.quizora.data.model.Question
import com.technovix.quizora.viewmodel.TriviaViewModel

@Composable
fun QuestionList(viewModel: TriviaViewModel) {
    val questions = viewModel.questions.collectAsState()

    val groupedQuestions = questions.value.groupBy { it.category }


    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        groupedQuestions.forEach { (category, questionList) ->
            item {
                Text(
                    text = "Category: $category",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp)
                )
            }

            items(questionList) { question ->
                QuestionItem(question = question)
            }
        }
    }
}

@Composable
fun QuestionItem(question: Question) {
    var selectedAnswer by remember { mutableStateOf("") }
    var isCorrect by remember { mutableStateOf<Boolean?>(null) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Difficulty: ${question.difficulty}")
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = question.question, modifier = Modifier.padding(top = 8.dp))


        }
    }
}