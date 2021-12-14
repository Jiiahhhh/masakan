package com.tugas.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MasakClient {
    val base_url = "https://masak-apa.tomorisakura.vercel.app/"

    val INSTANCE : MasakEndPoint by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(MasakEndPoint::class.java)
    }
}