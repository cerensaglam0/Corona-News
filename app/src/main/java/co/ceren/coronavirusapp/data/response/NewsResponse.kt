package co.ceren.coronavirusapp.data.response


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("result")
    val news: ArrayList<News>?,
    @SerializedName("success")
    val success: Boolean?
)