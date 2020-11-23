package com.mudassir.moviesapp.ui.webview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.databinding.DataBindingUtil
import com.mudassir.moviesapp.R
import com.mudassir.moviesapp.databinding.FragmentWebViewBinding
import com.mudassir.moviesapp.util.AppConstants

class WebViewFragment : Fragment() {

    lateinit var mBinding: FragmentWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_web_view, container, false)
        openUrl()
        return mBinding.root
    }
    private fun openUrl(){
        //TODO this can be improved more
        val webSettings: WebSettings = mBinding.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mBinding.webview.loadUrl(AppConstants.WEB_VIEW_URL)
    }

}