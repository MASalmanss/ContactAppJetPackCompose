package com.example.contactappjetpackcompose.uix.view

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun KisiKayitSayfa(){
    var tfKisiAd by remember { mutableStateOf("") }
    var tfKisiTel by remember { mutableStateOf("") }

    fun kaydet(kisi_da : String , kisi_tel : String){

    }

    Scaffold (topBar = { TopAppBar(title = { Text("Kişi Kayıt") }) })
    { innerpadding ->
        Column (modifier = Modifier.fillMaxSize().padding(innerpadding)
            , verticalArrangement = Arrangement.SpaceEvenly
            , horizontalAlignment = Alignment.CenterHorizontally)
        {
            TextField(value = tfKisiAd , onValueChange = {tfKisiAd = it} , label = { Text(text = "Kişi Ad") } )
            TextField(value = tfKisiTel , onValueChange = {tfKisiTel = it} , label = { Text(text = "Kişi Tel") } )

            Button(modifier = Modifier.size(250.dp , 50.dp) , onClick = {kaydet(tfKisiAd , tfKisiTel)}) {
                Text(text = "Kaydet")
            }
        }
    }
}