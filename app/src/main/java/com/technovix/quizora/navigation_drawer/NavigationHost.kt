package com.technovix.quizora.navigation_drawer

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.technovix.quizora.categoryList
import com.technovix.quizora.CategoryItem
import com.technovix.quizora.ui.screens.CategoryScreen
import com.technovix.quizora.ui.screens.LeaderboardScreen
import com.technovix.quizora.ui.screens.PrivacyPolicyScreen
import com.technovix.quizora.ui.screens.QuestionsScreen
import com.technovix.quizora.ui.screens.SettingsScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "category") {
        composable("category") {
            CategoryScreen(
                categories = categoryList,
                onCategoryClick = { category, level ->
                    navController.navigate("questions/${category.title}/${level}")
                }
            )
        }

        composable(
            "questions/{category}/{level}",
            arguments = listOf(navArgument("category") { type = NavType.StringType }, navArgument("level") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: ""
            val level = backStackEntry.arguments?.getString("level") ?: ""
            val selectedCategory = categoryList.first { it.title == category }
            QuestionsScreen(category = selectedCategory, difficultyLevel = level)
        }

        composable("leaderboard") {
            LeaderboardScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
        composable("help") {
            PrivacyPolicyScreen()
        }
    }
}

