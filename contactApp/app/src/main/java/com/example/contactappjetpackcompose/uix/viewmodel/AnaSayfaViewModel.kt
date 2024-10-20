package com.example.contactappjetpackcompose.uix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactappjetpackcompose.data.entity.Kisiler
import com.example.contactappjetpackcompose.data.repo.KisilerRepository
import kotlinx.coroutines.launch

class AnaSayfaViewModel : ViewModel() {

    private val krepo = KisilerRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>(emptyList())


    fun kisiyukle() {
        viewModelScope.launch {
            kisilerListesi.value = krepo.kisiyukle()
        }
    }


    fun sil(kisi: Kisiler) {
        viewModelScope.launch {

            kisilerListesi.value = kisilerListesi.value?.filter { it.kisi_id != kisi.kisi_id }
        }
    }


    fun ara(aramaKelimesi: String) {
        viewModelScope.launch {
            val filteredList = krepo.kisiyukle().filter {
                it.kisi_ad.contains(aramaKelimesi, ignoreCase = true)
            }
            kisilerListesi.value = filteredList
        }
    }
}
