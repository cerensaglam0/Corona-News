package co.ceren.coronavirusapp.ui.detail

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {
    val urlLiveData = MutableLiveData<String>()

    fun handleIntent(extras: Bundle?) {
        urlLiveData.value = extras?.getString("url")
    }
}
