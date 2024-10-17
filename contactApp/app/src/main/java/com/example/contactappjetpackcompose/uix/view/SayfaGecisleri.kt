package com.example.contactappjetpackcompose.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SayfaGecis(){
    var sayfaGecisController = rememberNavController()
    NavHost(navController = sayfaGecisController , startDestination = "anasayfa"){
        composable("anasayfa"){
            AnaSayfa(sayfaGecisController)
        }

        composable("KisiKayitSayfa"){
            KisiKayitSayfa()
        }

        composable("KisiDetaySayfa"){
            KisiDetaySayfa()
        }
    }
}