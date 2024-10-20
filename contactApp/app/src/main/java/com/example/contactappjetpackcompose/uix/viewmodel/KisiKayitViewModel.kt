package com.example.contactappjetpackcompose.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactappjetpackcompose.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiKayitViewModel : ViewModel() {
    private var krepo = KisilerRepository()

     fun kaydet(kisi_ad : String , kisi_tel : String){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.kaydet(kisi_ad , kisi_tel)
        }
    }
}