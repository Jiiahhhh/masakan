package com.tugas.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface MasakEndPoint {
    @GET("api/recipes")
    fun getDataResep(): Call<MasakModel>

}