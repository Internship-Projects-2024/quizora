package com.technovix.quizora.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.technovix.quizora.ui.screens.ui.theme.QuizoraTheme
import androidx.navigation.compose.rememberNavController
import com.technovix.quizora.MainScreen
import com.technovix.quizora.R
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizoraTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash" ) {
                    composable("splash") {
                        SplashScreen(navController = navController)
                    }
                    composable("home") {
                        MainScreen(context = LocalContext.current)
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    // Splash ekranının görünme süresi (örneğin 2 saniye)
    LaunchedEffect(Unit) {
        delay(5000) // 2 saniye bekleyin
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }

    // Splash ekranı içeriği
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Column içerisine yerleştiriyoruz
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center, // Hoşgeldiniz mesajını ortalayın
            horizontalAlignment = Alignment.CenterHorizontally // Hoşgeldiniz mesajını yatayda ortalayın
        ) {
            // Hoşgeldiniz mesajı
            Text(
                text = "Hoşgeldiniz!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Logo ve metin alt kısma yerleştirildi
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Alt kısma hizalayın
                .padding(80.dp), // Alt kısma padding ekleyin
            horizontalArrangement = Arrangement.Center, // Logo ve metni ortalayın
            verticalAlignment = Alignment.CenterVertically // Logo ve metni dikeyde hizalayın
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.technovix), // Drawable'dan logo resmi yükleyin
                contentDescription = "Technovix Logo",
                modifier = Modifier
                    .size(40.dp) // Boyutu 40x40 dp olarak ayarlayın
            )

            // Metin: "Made by TECHNOVIX"
            Text(
                text = "Made by TECHNOVIX",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp) // Logo ile metin arasındaki boşluğu ayarla
            )
        }
    }
}


