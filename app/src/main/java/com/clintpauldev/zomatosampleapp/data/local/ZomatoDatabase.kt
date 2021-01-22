package com.clintpauldev.zomatosampleapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ZomatoUser::class],
    version = 1
)
abstract class ZomatoDatabase : RoomDatabase() {

    abstract fun zomatoDao(): ZomatoDao

}