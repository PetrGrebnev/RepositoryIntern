package com.example.repositoryintern.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.repositoryintern.R
import com.example.repositoryintern.ui.adapter.RecyclerViewAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//пока не реализовано разбираюсь
@Module
class AppModule(context: Context) {

    @Singleton
    @Provides
    fun providerGlide(context: Context) =
        Glide.with(context)
            .setDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.drawable.im_placeholder)
                    .error(R.drawable.im_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
            )
}