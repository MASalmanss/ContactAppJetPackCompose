package com.example.contactappjetpackcompose.uix.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.contactappjetpackcompose.R
import com.example.contactappjetpackcompose.data.entity.Kisiler
import com.google.gson.Gson
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaSayfa(navController: NavController) {

    var aramaYapiliyorMu by remember { mutableStateOf(false) }
    var tf by remember { mutableStateOf("") }
    var kisilerListesi by remember { mutableStateOf(listOf<Kisiler>()) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    // Başlangıçta örnek veri eklenmesi için
    LaunchedEffect(key1 = 1) {
        val k1 = Kisiler(1, "Akif", "1111")
        val k2 = Kisiler(2, "Ahmet", "2222")
        val k3 = Kisiler(3, "Gizem", "3333")
        kisilerListesi = kisilerListesi + k1 + k2 + k3
    }

    fun ara(aramaKelimesi: String) {
        // Arama işlemi buraya
    }

    fun sil(silinecekKisi: Kisiler) {
        kisilerListesi = kisilerListesi.filter { it.kisi_id != silinecekKisi.kisi_id }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                actions = {
                    IconButton(onClick = {
                        aramaYapiliyorMu = !aramaYapiliyorMu
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.ara_resim_24),
                            contentDescription = "Arama İkonu"
                        )
                    }
                },
                title = {
                    if (aramaYapiliyorMu) {
                        Text("Arama")
                    } else {
                        Text("Kişiler")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("KisiKayitSayfa")
                },
                content = {
                    Icon(
                        painter = painterResource(R.drawable.kapa_resim_24),
                        contentDescription = "Kişi Kayıt"
                    )
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(kisilerListesi) { kisi ->
                Card(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable {
                            val kisiJson = Gson().toJson(kisi)
                            navController.navigate("KisiDetaySayfa/$kisiJson")
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = kisi.kisi_ad, fontSize = 20.sp)
                            Spacer(modifier = Modifier.size(10.dp))
                            Text(text = kisi.kisi_tel)
                        }
                        IconButton(onClick = {
                            scope.launch {
                                sil(kisi) // Kişiyi listeden sil
                                snackbarHostState.showSnackbar("${kisi.kisi_ad} silindi.")
                            }
                        }) {
                            Icon(
                                painter = painterResource(R.drawable.kapa_resim_24),
                                contentDescription = "Sil",
                                tint = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}
