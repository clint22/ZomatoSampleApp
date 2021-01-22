package com.clintpauldev.zomatosampleapp.di

import android.content.Context
import androidx.room.Room
import com.clintpauldev.zomatosampleapp.data.local.ZomatoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
object TestAppModule {

    @Provides
    @Named("test_db")
    fun providesInMemoryDb(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context, ZomatoDatabase::class.java).allowMainThreadQueries()
            .build()


}