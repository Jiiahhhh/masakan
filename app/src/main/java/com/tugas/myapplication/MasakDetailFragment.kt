package com.tugas.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_masak_detail.*

class MasakDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_masak_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get()
            .load(MasakData.thumb)
            .into(imgMasakDetail)
        tvDurasiDetail.text = MasakData.times
        tvLevelDetail.text = MasakData.dificulty
        tvPorsiDetail.text = MasakData.portion
        tvTitleDetail.text = MasakData.title

        btnShare.setOnClickListener {
            val intent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Masakan ini adalah ${MasakData.title} dengan durasi masak selama ${MasakData.times}")
                type = "text/plain"
            }
            val i = Intent.createChooser(intent, null)
            startActivity(i)
        }
    }
}