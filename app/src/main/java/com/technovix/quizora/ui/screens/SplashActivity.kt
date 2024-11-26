package com.technovix.quizora.ui.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.technovix.quizora.MainActivity
import com.technovix.quizora.R
import com.technovix.quizora.ui.theme.QuizoraTheme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizoraTheme {
                SplashScreen {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    val alpha = remember { mutableStateOf(0f) } // Başlangıçta tamamen şeffaf
    val animatedAlpha = animateFloatAsState(
        targetValue = alpha.value,
        animationSpec = androidx.compose.animation.core.tween(3000) // 2 saniyelik animasyon
    )

    LaunchedEffect(Unit) {
        delay(1000) // 1 saniye bekleyin
        alpha.value = 1f // Şeffaflığı 1'e çıkararak görünür yapın
        delay(3000) // Animasyon tamamlandıktan sonra 3 saniye bekleyin
        onTimeout() // Süre bitince callback fonksiyonu çağrılır
    }

    // Splash ekranının tasarımı
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hoşgeldiniz!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.alpha(animatedAlpha.value) // Animasyonlu şeffaflık
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(80.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.technovix),
                contentDescription = "Technovix Logo",
                modifier = Modifier
                    .size(40.dp)
                    .alpha(animatedAlpha.value) // Animasyonlu şeffaflık
            )
            Text(
                text = "Made by TECHNOVIX",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .alpha(animatedAlpha.value) // Animasyonlu şeffaflık
            )
        }
    }
}

