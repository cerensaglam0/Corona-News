package co.ceren.coronavirusapp.data

import co.ceren.coronavirusapp.data.api.ApiUtils
import co.ceren.coronavirusapp.data.response.NewsResponse
import retrofit2.Call

class RemoteDataSource {
    fun getCoronaNews(): Call<NewsResponse>? {
        return ApiUtils.getApiService()?.getCoronaNews()
    }
}

//datayla uğraşacağın herşey