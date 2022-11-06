package com.example.repositoryintern.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.repositoryintern.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//пока не реализовано разбираюсь
@InstallIn(SingletonComponent::class)
@Module
class AppModule() {

    @Singleton
    @Provides
    fun providerGlide( @ApplicationContext context: Context) =
        Glide.with(context)
            .setDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.drawable.im_placeholder)
                    .error(R.drawable.im_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
            )
}