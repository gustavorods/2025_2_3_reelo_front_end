package com.example.noticias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.noticias.data.News
import com.example.noticias.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            NewsVerticalPagerPrototype()
            NewsScreen()
        }
}

    // Tela pra testar a api
    @Composable
    fun NewsScreen() {
        var newsList by remember { mutableStateOf<List<News>?>(null) }
        var errorMsg by remember { mutableStateOf<String?>(null) }

        LaunchedEffect(Unit) {
            try {
                newsList = RetrofitInstance.api.getNews()
            } catch (e: Exception) {
                errorMsg = "Erro ao carregar notícias: ${e.message}"
            }
        }

        when {
            errorMsg != null -> {
                Text(text = errorMsg!!, color = Color.Red)
            }
            newsList == null -> {
                Text(text = "Carregando...", color = Color.Gray)
            }
            else -> {
                Column {
                    newsList!!.forEach {
                        Text(text = it.title, color = Color.White)
                        Text(text = it.source.name, color = Color.LightGray)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }


    @Composable
fun NewsVerticalPagerPrototype() {
    val items = List(50) { "Notícia #${it + 1}" }
    val pagerState = rememberPagerState { items.size }

    Scaffold(containerColor = Color.Black) { padding ->
        VerticalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) { page ->
            NewsCardPlaceholder(Titulo = items[page], "oui")
        }
    }
}

@Composable
fun NewsCardPlaceholder(Titulo: String, Resumo: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF111111))
            .padding(vertical = 24.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium)
                .background(Color(0xFF222222)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagem placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .background(Color(0xFF444444)),
                contentAlignment = Alignment.Center
            ) {
                Text("Imagem", color = Color.LightGray, fontSize = 22.sp)
            }
            Spacer(Modifier.height(18.dp))
            // Título
            Text(
                text = Titulo,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(Modifier.height(12.dp))
            // Fonte / Autor
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Fonte", color = Color(0xFFAAAAAA), fontSize = 14.sp)
                Text("Autor", color = Color(0xFFAAAAAA), fontSize = 14.sp)
            }
            // Data
            Text(
                "Data",
                color = Color(0xFFCCCCCC),
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp)
                    .align(Alignment.Start)
            )
            Spacer(Modifier.height(16.dp))
            // Resumo/Descrição
            Text(
                "Resumo",
                color = Color(0xFFEEEEEE),
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(Modifier.height(22.dp))
            // Botões placeholder
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                ) { Text("Curtir", color = Color.White) }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                ) { Text("Salvar", color = Color.White) }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333388))
                ) { Text("Leia mais", color = Color.White) }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewsVerticalPagerPreview() {
    NewsVerticalPagerPrototype()
    }
}