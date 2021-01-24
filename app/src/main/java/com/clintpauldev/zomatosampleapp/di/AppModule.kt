package com.clintpauldev.zomatosampleapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.clintpauldev.zomatosampleapp.data.local.ZomatoDao
import com.clintpauldev.zomatosampleapp.data.local.ZomatoDatabase
import com.clintpauldev.zomatosampleapp.data.remote.ZomatoApi
import com.clintpauldev.zomatosampleapp.data.repositories.DefaultZomatoRepository
import com.clintpauldev.zomatosampleapp.data.repositories.ZomatoRepository
import com.clintpauldev.zomatosampleapp.other.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideZomatoDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ZomatoDatabase::class.java, Constants.DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideDefaultZomatoRepository(
        dao: ZomatoDao,
        api: ZomatoApi
    ) = DefaultZomatoRepository(dao, api) as ZomatoRepository

    @Provides
    @Singleton
    fun provideZomatoDao(
        database: ZomatoDatabase
    ) = database.zomatoDao()

    @Provides
    @Singleton
    fun provideZomatoApi(): ZomatoApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(ZomatoApi::class.java)
    }

}