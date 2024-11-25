package com.technovix.quizora.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.technovix.quizora.ui.trivia.QuestionList
import com.technovix.quizora.viewmodel.TriviaViewModel

@Composable
fun TriviaScreen(viewModel: TriviaViewModel) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { viewModel.loadQuestions(10, null, "easy", "mulltiple") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Text("Fetch Questions")
        }

        QuestionList(viewModel = viewModel)
    }
}