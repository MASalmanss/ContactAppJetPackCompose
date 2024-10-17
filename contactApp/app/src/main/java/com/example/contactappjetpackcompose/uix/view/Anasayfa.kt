package com.example.contactappjetpackcompose.uix.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.contactappjetpackcompose.R
import com.example.contactappjetpackcompose.data.entity.Kisiler
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaSayfa(navController: NavController) {

    var aramaYapiliyorMu by remember { mutableStateOf(false) }
    var tf by remember { mutableStateOf("") }

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
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier.size(250.dp, 50.dp),
                onClick = {
                    val kisi = Kisiler(1, "Ahmet", "1111")
                    val kisiJson = Gson().toJson(kisi)
                    navController.navigate("KisiDetaySayfa/$kisiJson")
                }
            ) {
                Text(text = "Detay")
            }
        }
    }
}
