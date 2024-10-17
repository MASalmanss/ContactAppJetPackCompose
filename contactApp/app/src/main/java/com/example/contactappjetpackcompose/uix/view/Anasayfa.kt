package com.example.contactappjetpackcompose.uix.view

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.contactappjetpackcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaSayfa(navController: NavController){
    Scaffold (topBar = { TopAppBar(title = { Text("Ana Sayfa") }) }
            , floatingActionButton = { FloatingActionButton(onClick = {navController.navigate("KisiKayitSayfa")}
            , content = { Icon(painter = painterResource(R.drawable.kapa_resim_24) , contentDescription = "") })} )
    { innerpadding ->
        Column (modifier = Modifier.fillMaxSize().padding(innerpadding)
            , verticalArrangement = Arrangement.SpaceEvenly
            , horizontalAlignment = Alignment.CenterHorizontally)
        {

        }
    }
}