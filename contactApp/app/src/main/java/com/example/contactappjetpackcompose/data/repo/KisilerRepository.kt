package com.example.contactappjetpackcompose.data.repo

import com.example.contactappjetpackcompose.data.datasource.KisilerDataSource
import com.example.contactappjetpackcompose.data.entity.Kisiler

class KisilerRepository {
    var kds = KisilerDataSource()
    suspend fun kaydet(kisi_ad : String , kisi_tel : String) = kds.kaydet(kisi_ad , kisi_tel)
    suspend fun guncelle(kisi_ad : String , kisi_tel : String) = kds.guncelle(kisi_ad , kisi_tel)

    suspend fun kisiyukle() : List<Kisiler> = kds.kisiyukle()
}