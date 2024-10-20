package com.example.contactappjetpackcompose.uix.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.contactappjetpackcompose.R
import com.example.contactappjetpackcompose.data.entity.Kisiler
import com.example.contactappjetpackcompose.uix.viewmodel.AnaSayfaViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaSayfa(navController: NavController, anaSayfaViewModel: AnaSayfaViewModel) {

    var aramaYapiliyorMu by remember { mutableStateOf(false) }
    var tf by remember { mutableStateOf("") }
    val kisilerListesi by anaSayfaViewModel.kisilerListesi.observeAsState(listOf()) // Listeyi gözlemliyoruz
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    fun ara(aramaKelimesi: String) {
       // anaSayfaViewModel.ara(aramaKelimesi)  // Arama işlemi ViewModel'de yapılmalı
    }

    fun sil(kisi: Kisiler) {
       // anaSayfaViewModel.sil(kisi)  // Silme işlemi ViewModel'de yapılmalı
    }

    LaunchedEffect(key1 = true) {
        anaSayfaViewModel.kisiyukle()
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
                            Text(text = kisi.kisi_ad, fontSize = 20.sp) // kisi.kisi_ad eksik yazılmış
                            Spacer(modifier = Modifier.size(10.dp))
                            Text(text = kisi.kisi_tel)
                        }
                        IconButton(onClick = {
                            scope.launch {
                                sil(kisi) // Kişiyi ViewModel'den sil
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
