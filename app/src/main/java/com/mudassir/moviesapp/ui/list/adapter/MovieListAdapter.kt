package com.mudassir.moviesapp.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mudassir.moviesapp.R
import com.mudassir.moviesapp.databinding.SingleItemMovieBinding
import com.mudassir.moviesapp.model.Movie

class MovieListAdapter : PagingDataAdapter<Movie, MovieListAdapter.ViewHolder>(COMPARATOR) {

    private var callbacks: Callbacks? = null
    fun setupListener(listener: Callbacks?) {
        this.callbacks = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: SingleItemMovieBinding =
            DataBindingUtil.inflate(inflater, R.layout.single_item_movie, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    interface Callbacks {
        fun onMovieItemClick(view: View, item: Movie)
    }

    inner class ViewHolder(val binding: SingleItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.apply {
                palette = txtTitle
                binding.item = movie
                lyMovieItem.setOnClickListener {
                    callbacks?.onMovieItemClick(it, movie)
                }
                executePendingBindings()
            }

        }
    }

    object COMPARATOR : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

}