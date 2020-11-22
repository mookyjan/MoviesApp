package com.mudassir.moviesapp.ui.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.github.ajalt.timberkt.Timber
import com.mudassir.moviesapp.R
import com.mudassir.moviesapp.databinding.MovieListFragmentBinding
import com.mudassir.moviesapp.model.Movie
import com.mudassir.moviesapp.ui.list.adapter.LoadingGridStateAdapter
import com.mudassir.moviesapp.ui.list.adapter.MovieListAdapter
import com.mudassir.moviesapp.util.AppConstants
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieListFragment : Fragment(), MovieListAdapter.Callbacks {

    companion object {
        fun newInstance() = MovieListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MovieListViewModel
    lateinit var mBinding: MovieListFragmentBinding

    @Inject
    lateinit var mAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.movie_list_fragment, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel =
            ViewModelProvider(this, this.viewModelFactory).get(MovieListViewModel::class.java)
        mBinding.viewModel = viewModel
        mBinding.lifecycleOwner = this
        viewModel.getMovieList()
        observeEvents()
        setupForAdapter()
    }

    private fun observeEvents() {

        viewModel.error.observe(viewLifecycleOwner, Observer {
            Timber.e { "Error $it" }
            Toast.makeText(activity, "Error $it", Toast.LENGTH_SHORT).show()
        })

        viewModel.movieList.observe(viewLifecycleOwner, Observer {

            mAdapter.submitData(lifecycle, it)

        })

    }

    private fun setupForAdapter() {
        mAdapter.setupListener(this)
        mBinding.rvMovies.adapter = mAdapter
        mBinding.rvMovies.adapter = mAdapter.withLoadStateFooter(
            footer = LoadingGridStateAdapter()
        )
        mAdapter.addLoadStateListener { loadState ->
            val errorState = loadState.source.append as? LoadState.Error
                ?: loadState.source.prepend as? LoadState.Error
                ?: loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error

            errorState?.let {
                AlertDialog.Builder(view?.context)
                    .setTitle(R.string.txt_error)
                    .setMessage(it.error.localizedMessage)
                    .setNegativeButton(R.string.txt_cancel) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.txt_retry) { _, _ ->
                        mAdapter.retry()
                    }
                    .show()
            }
        }

        mBinding.lySwipeRefresh.setProgressViewOffset(false, mBinding.root.height / 2, 500)
    }


    override fun onMovieItemClick(view: View, item: Movie) {
        Timber.d { "clicked on movie" }
        val bundle = Bundle()
        bundle.putParcelable(AppConstants.MOVIE_ARGU, item)
        findNavController().navigate(R.id.action_movieListFragment_to_movieDetailFragment, bundle)
    }
}