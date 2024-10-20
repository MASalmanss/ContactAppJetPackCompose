package com.example.contactappjetpackcompose.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contactappjetpackcompose.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiDetayViewModel : ViewModel() {
    var krepo = KisilerRepository()
    fun guncelle(kisi_da : String , kisi_tel : String){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.kaydet(kisi_da , kisi_tel)
        }
    }
}