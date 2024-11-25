package com.technovix.quizora.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.technovix.quizora.ui.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class  MainState(
    val nickname: String? = null,
    val showDialog: Boolean = true,
    val categories: List<Category> = emptyList()
)

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val sharedPreferences = application.getSharedPreferences("app_preferences", Application.MODE_PRIVATE)

    private val _uiState = MutableStateFlow(MainState())
    val uiState: StateFlow<MainState> = _uiState

    init {
        viewModelScope.launch {
            val nickname = sharedPreferences.getString("nickname", null)
            val isFirstLaunch = sharedPreferences.getBoolean("is_first_launch", true)

            _uiState.value = MainState(
                nickname = nickname,
                showDialog = isFirstLaunch || nickname.isNullOrEmpty(),
                categories = listOf(
                    Category(1, "Bilim"),
                    Category(2, "Sanat"),
                    Category(3, "Spor"),
                    Category(4, "Teknoloji"),
                    Category(5, "Tarih")
                )
            )
        }
    }

    fun saveNickname(nickname: String) {
        viewModelScope.launch {
            sharedPreferences.edit().putString("nickname", nickname).apply()
            sharedPreferences.edit().putBoolean("is_first_launch", false).apply()

            _uiState.value = _uiState.value.copy(
                nickname = nickname,
                showDialog = false
            )
        }
    }
}