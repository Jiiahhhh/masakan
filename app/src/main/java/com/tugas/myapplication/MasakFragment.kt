package com.tugas.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_masak.*

class MasakFragment : Fragment() {

    lateinit var masakViewModel: MasakViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        masakViewModel = ViewModelProvider(this).get(MasakViewModel::class.java)
        return inflater.inflate(R.layout.fragment_masak, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMasak.setHasFixedSize(true)
        rvMasak.apply {
            layoutManager = GridLayoutManager(context, 2)
        }
//        rvMasak.layoutManager = LinearLayoutManager(context)
        masakViewModel.getDataFromApi(rvMasak, object : MasakViewModel.OnAdapterListener {
            override fun onClick(item: Result) {
                MasakData.fill(item)
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.container, MasakDetailFragment())
                    ?.addToBackStack(null)
                    ?.commit()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MasakFragment", "onDestroy dipanggil")
    }

    companion object{
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MasakFragment()
    }
}