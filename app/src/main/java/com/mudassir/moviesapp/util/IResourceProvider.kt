package com.mudassir.moviesapp.util

import android.content.Context
import javax.inject.Inject

class IResourceProvider @Inject constructor(private val context: Context) {

    fun getString(resId: Int): String {
        return context.getString(resId)
    }

    fun getString(resId: Int, int: Int): String {
        return context.getString(resId, int)
    }

    fun getString(resId: Int, string: String): String {
        return context.getString(resId, string)
    }

    fun getString(resId: Int,int: Int,string: String):String{
        return context.getString(resId,int,string)
    }

    fun getStringArray(resId: Int): Array<String> {
        return context.resources.getStringArray(resId)
    }
}