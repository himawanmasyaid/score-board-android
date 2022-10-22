package com.himawanmasyaid.scoreboardandroid.model

import android.content.Context
import com.himawanmasyaid.scoreboardandroid.R

class SportModel(
    val id: Int,
    val name: String,
    val total_score: Int,
    val image: Int = 0,
    val is_have_time_duration: Boolean = false,
    val total_time_duration: Long = 0, // 2000 : 2 second (time millisecond)
)

fun getSportListData(context: Context): List<SportModel> {

    return listOf(
        SportModel(
            id = 1,
            name = context.getString(R.string.badminton),
            total_score = 21,
            image = R.drawable.ic_badminton
        ),
        SportModel(
            id = 2,
            name = context.getString(R.string.table_tennis),
            total_score = 11,
            image = R.drawable.ic_tenis_table
        ),
        SportModel(
            id = 3,
            name = context.getString(R.string.volleyball),
            total_score = 24,
            image = R.drawable.ic_volleyball
        ),
    )

}

fun getSportDetail( context: Context, id: Int) : SportModel?{
    return try {
        getSportListData(context).find { it.id == id }
    } catch (error: Exception) {
        null
    }
}
