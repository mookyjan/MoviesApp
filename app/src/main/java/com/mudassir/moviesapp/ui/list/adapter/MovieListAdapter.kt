package com.mudassir.moviesapp.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.ajalt.timberkt.Timber
import com.mudassir.moviesapp.R
import com.mudassir.moviesapp.databinding.SingleItemMovieBinding
import com.mudassir.moviesapp.model.Movie

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    var movieList = listOf<Movie>()
    private var callbacks: Callbacks? = null

    fun setData(list: List<Movie>){
        movieList =list
    }
    fun setupListener(listener: Callbacks?){
        this.callbacks=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Timber.d { "audio book list $movieList" }
        val inflater = LayoutInflater.from(parent.context)
        val binding: SingleItemMovieBinding =
            DataBindingUtil.inflate(inflater, R.layout.single_item_movie, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieEntity =movieList.get(position)
        holder.binding.item = movieEntity
        holder.binding.txtTitle.text = movieEntity.title
//        holder.binding.txtSerialNo.text =(position+1).toString()
        holder.binding.executePendingBindings()
    }

    interface Callbacks {
        fun onMovieItemClick(view: View, item: Movie)
    }

    inner class ViewHolder(val binding: SingleItemMovieBinding) : RecyclerView.ViewHolder(binding.root){

    }
}