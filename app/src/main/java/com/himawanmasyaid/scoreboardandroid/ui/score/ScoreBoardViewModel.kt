package com.himawanmasyaid.scoreboardandroid.ui.score

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himawanmasyaid.scoreboardandroid.model.ScoreBoardModel
import com.himawanmasyaid.scoreboardandroid.model.SportModel
import com.himawanmasyaid.scoreboardandroid.model.getSportDetail
import com.himawanmasyaid.scoreboardandroid.model.state.ViewState
import kotlinx.coroutines.launch

class ScoreBoardViewModel() : ViewModel() {

    val scoreBoardState = MutableLiveData<ViewState<ScoreBoardModel>>()

    fun getScoreBoardBySportId(context: Context, id: Int) {

        viewModelScope.launch {
            scoreBoardState.postValue(ViewState.Loading())
            try {
                val sport = getSportDetail(context, id)

                if (sport == null) {
                    scoreBoardState.postValue(ViewState.Error(null))
                } else {

                    val scoreList: MutableList<Int> = ArrayList()
                    for (item in 0 until sport.total_score + 1) {
                        scoreList.add(item)
                    }

                    scoreBoardState.postValue(
                        ViewState.Success(
                            ScoreBoardModel(
                                sport = sport,
                                scoreList = scoreList
                            )
                        )
                    )

                }

            } catch (error: Exception) {
                scoreBoardState.postValue(ViewState.Error(null))
            }
        }


    }

}