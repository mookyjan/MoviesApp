package com.mudassir.moviesapp.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.mudassir.moviesapp.R
import com.mudassir.moviesapp.databinding.LoadingBarBinding

class LoadingGridStateViewHolder(
    private val binding: LoadingBarBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(loadState: LoadState) {
        binding.progressBar.isVisible = loadState is LoadState.Loading
    }

    companion object {
        fun create(parent: ViewGroup): LoadingGridStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.loading_bar, parent, false)

            val binding = LoadingBarBinding.bind(view)

            return LoadingGridStateViewHolder(
                binding
            )
        }
    }
}