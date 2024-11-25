package com.technovix.quizora.ui.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.technovix.quizora.R
import com.technovix.quizora.ui.theme.QuizoraTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
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

    var alphaState by remember { mutableStateOf(0f) }

    val alphaAnim by animateFloatAsState(
        targetValue = alphaState,
        animationSpec = tween(durationMillis = 5000)
    )

    LaunchedEffect(Unit) {
        alphaState = 1f
        delay(5000)
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
                fontWeight = FontWeight.Bold,
                color = Color.Black.copy(alpha = alphaAnim)
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
                    .alpha(alphaAnim)
            )

            // Metin: "Made by TECHNOVIX"
            Text(
                text = "Made by TECHNOVIX",
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dp) // Logo ile metin arasındaki boşluğu ayarla
                    .alpha(alphaAnim)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    val fakeNavController = rememberNavController()
    QuizoraTheme {
        SplashScreen(navController = fakeNavController)
    }
}



