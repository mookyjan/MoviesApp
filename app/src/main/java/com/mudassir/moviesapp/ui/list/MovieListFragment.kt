package com.mudassir.moviesapp.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.github.ajalt.timberkt.Timber
import com.mudassir.moviesapp.R
import com.mudassir.moviesapp.databinding.MovieListFragmentBinding
import com.mudassir.moviesapp.model.Movie
import com.mudassir.moviesapp.ui.list.adapter.MovieListAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieListFragment : Fragment() ,MovieListAdapter.Callbacks{

    companion object {
        fun newInstance() = MovieListFragment()
    }

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var viewModel: MovieListViewModel
    lateinit var mBinding: MovieListFragmentBinding
    @Inject
    lateinit var mAdapter : MovieListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.movie_list_fragment, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProvider(this,this.viewModelFactory).get(MovieListViewModel::class.java)
        mBinding.viewModel= viewModel
        mBinding.lifecycleOwner=this

        viewModel.getMovieList()

        observeEvents()
        setupForAdapter()
    }

    private fun observeEvents(){

        viewModel.error.observe(viewLifecycleOwner, Observer {
            Timber.e { "Error $it" }
            Toast.makeText(activity,"Error $it", Toast.LENGTH_SHORT).show()
        })

        viewModel.movieList.observe(viewLifecycleOwner, Observer {
            Timber.d { "list of movies ${it.size}" }
            mAdapter.setData(it)
            mAdapter.notifyDataSetChanged()
        })

    }

    private fun setupForAdapter(){
        mAdapter.setupListener(this)
        mBinding.rvMovies.adapter=mAdapter
        mBinding.lySwipeRefresh.setProgressViewOffset(false,mBinding.root.height/2,500)
    }


    override fun onMovieItemClick(view: View, item: Movie) {
        Timber.d { "clicked on movie" }
    }
}