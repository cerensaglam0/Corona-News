package co.ceren.coronavirusapp.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.ceren.coronavirusapp.R
import co.ceren.coronavirusapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.handleIntent(intent.extras)

        setupToolbar()
        setUpWebView()
        setUpObserve()
    }

    private fun setUpObserve() {
        viewModel.urlLiveData.observe(this, Observer {
            if (it != null) {
                binding.webView.loadUrl(it)
            }
        })
    }


    @SuppressLint("SetJavaScriptEnabled")
    private fun setUpWebView() {

        with(binding.webView) {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressBar.isVisible = false
                }
            }
        }
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}