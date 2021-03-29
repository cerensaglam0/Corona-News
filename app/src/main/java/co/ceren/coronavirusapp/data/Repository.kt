package co.ceren.coronavirusapp.data

import co.ceren.coronavirusapp.data.response.NewsResponse
import retrofit2.Call

class Repository {
    private val remoteDataSource = RemoteDataSource()

    fun getCoronaNews(): Call<NewsResponse>? {
        return remoteDataSource.getCoronaNews()
    }


}