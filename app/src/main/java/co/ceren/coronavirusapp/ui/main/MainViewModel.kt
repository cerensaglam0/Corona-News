package co.ceren.coronavirusapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.ceren.coronavirusapp.data.Repository
import co.ceren.coronavirusapp.data.response.News
import co.ceren.coronavirusapp.data.response.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val repository = Repository()

    val errorLiveData = MutableLiveData<Throwable>()
    val responseLiveData = MutableLiveData<ArrayList<News>>()
    val loadingLiveData = MutableLiveData<Boolean>()

    fun getCoronaNews() {
        loadingLiveData.value = true
        repository.getCoronaNews()?.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                errorLiveData.value = t
                loadingLiveData.value = false
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                responseLiveData.value = response.body()?.news ?: arrayListOf()
                loadingLiveData.value = false
            }

        })
    }
}

//Livedatalarla mainactivity e veri aktarılıyor.