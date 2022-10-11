package com.himawanmasyaid.scoreboardandroid.model

class SportModel(
    val id: Int,
    val name: String,
    val total_score: Int,
    val image: Int = 0,
    val is_have_time_duration: Boolean = false,
    val total_time_duration: Int = 0, // 2000 : 2 second (time millisecond)
)