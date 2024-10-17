package com.example.contactappjetpackcompose.uix.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contactappjetpackcompose.data.entity.Kisiler
import com.google.gson.Gson

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

        composable("KisiDetaySayfa/{kisi}"
            , arguments = listOf(navArgument("kisi"){ type = NavType.StringType})){
            val json = it.arguments?.getString("kisi")
            val nesne = Gson().fromJson(json , Kisiler::class.java)
            KisiDetaySayfa(nesne)
        }
    }
}