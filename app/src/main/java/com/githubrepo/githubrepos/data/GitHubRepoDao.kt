package com.githubrepo.githubrepos.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GitHubRepoDao {
    @Query("SELECT * FROM githubrepos ORDER BY name")
    fun getRepos(): LiveData<List<GitHubRepo>>

    @Query("SELECT * FROM githubrepos WHERE id = :repoId")
    fun getRepo(repoId: Int): LiveData<GitHubRepo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<GitHubRepo>)
}
