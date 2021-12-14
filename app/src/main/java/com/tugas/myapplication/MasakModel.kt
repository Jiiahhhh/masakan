package com.tugas.myapplication

data class MasakModel(
    val method: String,
    val results: List<Result>,
    val status: Boolean
)

data class Result(
    val dificulty: String,
    val key: String,
    val portion: String,
    val thumb: String,
    val times: String,
    val title: String
)
