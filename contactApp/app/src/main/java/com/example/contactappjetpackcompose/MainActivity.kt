package com.example.contactappjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.contactappjetpackcompose.ui.theme.ContactAppJetPackComposeTheme
import com.example.contactappjetpackcompose.uix.view.SayfaGecis
import com.example.contactappjetpackcompose.uix.viewmodel.AnaSayfaViewModel
import com.example.contactappjetpackcompose.uix.viewmodel.KisiDetayViewModel
import com.example.contactappjetpackcompose.uix.viewmodel.KisiKayitViewModel

class MainActivity : ComponentActivity() {

    val anaSayfaViewModel : AnaSayfaViewModel by viewModels()
    val kisiKayitViewModel : KisiKayitViewModel by viewModels()
    val kisiDetayViewModel : KisiDetayViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactAppJetPackComposeTheme {
                SayfaGecis(anaSayfaViewModel , kisiKayitViewModel , kisiDetayViewModel)
            }
        }
    }
}

