package co.ceren.coronavirusapp.data.api

import co.ceren.coronavirusapp.data.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewsApiService {

    @Headers(
        "content-type: application/json",
        "authorization: apikey 1LeKEUhIJ09SGb7X8PAP1Q:4LW1F7HE3qV28DaGoCngZm"
    )
    @GET("coronaNews")
    fun getCoronaNews(): Call<NewsResponse>

}


//web servis katmanı