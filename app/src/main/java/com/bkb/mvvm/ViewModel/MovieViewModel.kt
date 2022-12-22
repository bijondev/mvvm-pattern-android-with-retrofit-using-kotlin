package com.bkb.mvvm.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkb.mvvm.RetrofitInstance
import com.bkb.mvvm.model.Movies
import com.bkb.mvvm.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<Result>>()
    fun getPopularMovies() {
        val response:Call<Movies> = RetrofitInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0")

        response.enqueue(object :Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body()!=null){
                    movieLiveData.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<Result>> {
        return movieLiveData
    }
}
