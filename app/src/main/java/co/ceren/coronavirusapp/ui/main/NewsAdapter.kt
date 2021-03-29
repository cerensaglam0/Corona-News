package co.ceren.coronavirusapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.ceren.coronavirusapp.data.response.News
import co.ceren.coronavirusapp.databinding.ItemNewBinding
import com.bumptech.glide.Glide

class NewsAdapter(private val newsList: ArrayList<News>, private val callback: NewsAdapterCallback) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(val binding: ItemNewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNewBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.itemView.setOnClickListener {
            callback.onNewsItemClick(currentItem.url)
        }
        with(holder.binding) {
            textViewName.text = currentItem.name
            textViewSource.text = currentItem.source
            textViewDescription.text = currentItem.description
            Glide.with(holder.itemView.context).load(currentItem.image).into(imageViewNews)
        }
    }
}