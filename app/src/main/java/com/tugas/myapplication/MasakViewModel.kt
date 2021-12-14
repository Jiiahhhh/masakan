package com.tugas.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.Result

class MasakViewModel : ViewModel() {

    interface OnAdapterListener {
        fun onClick(item: com.tugas.myapplication.Result)
    }

    fun getDataFromApi(recyclerView: RecyclerView, listener: OnAdapterListener) {
        MasakClient.INSTANCE.getDataResep()
            .enqueue(object : Callback<MasakModel> {
                override fun onResponse(call: Call<MasakModel>, response: Response<MasakModel>) {
                    val data = response.body()?.results
                    recyclerView.adapter = MasakAdapter(
                        data as ArrayList<com.tugas.myapplication.Result>,
                        object : MasakAdapter.OnAdapterListener {
                            override fun onClick(item: com.tugas.myapplication.Result) {
                                listener.onClick(item)
                            }
                        })
                }

                override fun onFailure(call: Call<MasakModel>, t: Throwable) {
                    Log.d("MasakViewModel", "onFailure")
                }

            })
    }

}