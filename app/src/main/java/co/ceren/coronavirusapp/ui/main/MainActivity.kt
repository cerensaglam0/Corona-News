package co.ceren.coronavirusapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.ceren.coronavirusapp.R
import co.ceren.coronavirusapp.data.response.News
import co.ceren.coronavirusapp.databinding.ActivityMainBinding
import co.ceren.coronavirusapp.ui.detail.DetailActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity(), NewsAdapterCallback {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickSickPicture()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getCoronaNews()
        setUpObserve()

    }

    private fun setUpObserve() {
        viewModel.responseLiveData.observe(this, Observer {
            setupRecyclerView(it)
        })

        viewModel.errorLiveData.observe(this, Observer {
            showErrorDialog()
        })

        viewModel.loadingLiveData.observe(this, Observer {
            updateProgressBarVisibility(it)
        })
    }

    private fun setupRecyclerView(newsList: ArrayList<News>) {
        val adapter = NewsAdapter(newsList, this)
        binding.recyclerView.adapter = adapter
    }

    private fun showErrorDialog() {
        MaterialAlertDialogBuilder(this)
            .setCancelable(false)
            .setTitle("Error")
            .setMessage("An unknown error has occurred")
            .setPositiveButton("OK") { _, _ ->

            }.show()
    }

    private fun updateProgressBarVisibility(isVisible: Boolean) {
        binding.progressBar.isVisible = isVisible
    }

    override fun onNewsItemClick(url: String?) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }

    private fun onClickSickPicture(){
        binding.imageViewSickPicture.setOnClickListener {
            val popUpMenu= PopupMenu(this, binding.imageViewSickPicture)
            popUpMenu.menuInflater.inflate(R.menu.pop_up_menu, popUpMenu.menu)
            popUpMenu.show()

            popUpMenu.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.itemBadMood->{
                        binding.imageViewSickPicture.setImageResource(R.drawable.bad_mood)
                        Toast.makeText(this, "Başın ağrıyorsa ve nefes darlığı çekiyorsan en yakın bir sağlık kuruluşuna gitmekte fayda var", Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.itemGoodMood->{
                        binding.imageViewSickPicture.setImageResource(R.drawable.good_mood)
                        Toast.makeText(this, "Çok iyi", Toast.LENGTH_LONG).show()

                        true
                    }
                    R.id.itemPerfectMood->{
                        binding.imageViewSickPicture.setImageResource(R.drawable.perfect_mood)
                        Toast.makeText(this, "Harikasın !", Toast.LENGTH_LONG).show()

                        true
                    }
                    else ->false
                }
            }

        }
    }


}