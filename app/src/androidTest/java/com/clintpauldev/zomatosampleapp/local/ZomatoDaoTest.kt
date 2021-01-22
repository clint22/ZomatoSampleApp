package com.clintpauldev.zomatosampleapp.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.clintpauldev.zomatosampleapp.data.local.ZomatoDao
import com.clintpauldev.zomatosampleapp.data.local.ZomatoDatabase
import com.clintpauldev.zomatosampleapp.data.local.ZomatoUser
import com.clintpauldev.zomatosampleapp.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
@HiltAndroidTest
@SmallTest
class ZomatoDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: ZomatoDatabase
    private lateinit var zomatoDao: ZomatoDao

    @Before
    fun setup() {
        hiltRule.inject()
        zomatoDao = database.zomatoDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertUser() = runBlockingTest {
        val zomatoUser = ZomatoUser(
            username = "Clint",
            password = "clint123",
            id = 1
        )
        zomatoDao.insertUser(zomatoUser)
        val allZomatoUsers = zomatoDao.observeAllUsers().getOrAwaitValue()
        assertThat(allZomatoUsers).contains(zomatoUser)
    }

    @Test
    fun deleteUser() = runBlockingTest {
        val zomatoUser = ZomatoUser(
            username = "Clint",
            password = "clint123",
            id = 1
        )
        zomatoDao.insertUser(zomatoUser)
        zomatoDao.deleteUser(zomatoUser)

        val allZomatoUsers = zomatoDao.observeAllUsers().getOrAwaitValue()
        assertThat(allZomatoUsers).doesNotContain(zomatoUser)
    }

    @Test
    fun observeUser() = runBlockingTest {

        val zomatoUser1 = ZomatoUser(
            username = "Clint",
            password = "clint123",
            id = 1
        )

        val zomatoUser2 = ZomatoUser(
            username = "Sanjay",
            password = "sanjay123",
            id = 2
        )

        zomatoDao.insertUser(zomatoUser1)
        zomatoDao.insertUser(zomatoUser2)

        val observeZomatoUser =
            zomatoDao.observeUser(username = "Clint", password = "clint123").getOrAwaitValue()
        assertThat(observeZomatoUser).isEqualTo(zomatoUser1)
    }

}