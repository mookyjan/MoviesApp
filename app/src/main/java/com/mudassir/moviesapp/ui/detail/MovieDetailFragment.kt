package com.mudassir.moviesapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mudassir.moviesapp.R
import com.mudassir.moviesapp.databinding.MovieDetailFragmentBinding
import com.mudassir.moviesapp.model.Movie
import com.mudassir.moviesapp.util.AppConstants
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieDetailFragment : Fragment() {

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mBinding: MovieDetailFragmentBinding
    private lateinit var viewModel: MovieDetailViewModel
    lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movie = arguments?.getParcelable<Movie>(AppConstants.MOVIE_ARGU)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.movie_detail_fragment, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel =
            ViewModelProvider(this, this.viewModelFactory).get(MovieDetailViewModel::class.java)
        mBinding.viewModel = viewModel
        mBinding.lifecycleOwner = this
        viewModel.movieId.value = movie.id
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.movieId.observe(viewLifecycleOwner, Observer {
            viewModel.getMovieDetail(it)
        })
    }

}