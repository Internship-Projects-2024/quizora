package com.technovix.quizora.navigation_drawer

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.technovix.quizora.ui.screens.CategoryScreen
import com.technovix.quizora.ui.screens.LeaderboardScreen
import com.technovix.quizora.ui.screens.PrivacyPolicyScreen
import com.technovix.quizora.ui.screens.SettingsScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "category") {
        composable("category") { CategoryScreen() }
        composable("leaderboard") { LeaderboardScreen() }
        composable("settings") { SettingsScreen() }
        composable("help") { PrivacyPolicyScreen() }
    }
}