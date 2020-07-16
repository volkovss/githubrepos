package com.githubrepo.githubrepos.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GitHubRepoDao {
    @Query("SELECT * FROM githubrepos WHERE owner_login = :userName ORDER BY updatedAt DESC")
    fun getRepos(userName: String): LiveData<List<GitHubRepo>>

    @Query("SELECT * FROM githubrepos WHERE id = :repoId")
    fun getRepo(repoId: Int): LiveData<GitHubRepo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<GitHubRepo>)

    @Query("DELETE FROM githubrepos")
    fun clearRepos()

    @Query("DELETE FROM owners")
    fun clearOwners()

    @Transaction
    suspend fun clearCache() {
        clearOwners()
        clearRepos()
    }

}
