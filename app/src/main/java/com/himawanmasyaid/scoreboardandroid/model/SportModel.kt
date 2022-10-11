package com.himawanmasyaid.scoreboardandroid.model

import com.himawanmasyaid.scoreboardandroid.R

class SportModel(
    val id: Int,
    val name: String,
    val total_score: Int,
    val image: Int = 0,
    val is_have_time_duration: Boolean = false,
    val total_time_duration: Int = 0, // 2000 : 2 second (time millisecond)
)

fun getSportListData(): List<SportModel> {

    return listOf(
        SportModel(
            id = 1,
            name = "Bulutangkis",
            total_score = 21,
            image = R.drawable.ic_launcher_background
        ),
        SportModel(
            id = 2,
            name = "Tenis Meja",
            total_score = 12,
            image = R.drawable.ic_launcher_background
        ),
    )

}
