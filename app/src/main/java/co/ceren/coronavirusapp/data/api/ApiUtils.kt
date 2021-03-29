package co.ceren.coronavirusapp.data.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {
    private const val BASE_URL = "https://api.collectapi.com/corona/"
    private var retrofit: Retrofit? = null

    fun getApiService(): NewsApiService? {
        if (retrofit == null)
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
        return retrofit?.create(NewsApiService::class.java)
    }
}