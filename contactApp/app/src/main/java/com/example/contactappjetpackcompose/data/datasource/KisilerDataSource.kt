package com.example.contactappjetpackcompose.data.datasource

import android.util.Log
import com.example.contactappjetpackcompose.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {
    suspend fun kaydet(kisi_ad : String , kisi_tel : String){
        Log.e("kaydet" , "${kisi_ad+ "" + kisi_tel}")
    }


    suspend fun guncelle(kisi_da : String , kisi_tel : String){

    }

    suspend fun kisiyukle() : List<Kisiler> = withContext(Dispatchers.IO){
        var kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Akif", "1111")
        val k2 = Kisiler(2, "Ahmet", "2222")
        val k3 = Kisiler(3, "Gizem", "3333")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        Log.e("KisilerDataSource", "Yüklenen Kişiler: $kisilerListesi")

        return@withContext kisilerListesi
    }
}