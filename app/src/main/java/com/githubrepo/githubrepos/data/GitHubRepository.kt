package com.githubrepo.githubrepos.data

import com.githubrepo.githubrepos.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GitHubRepository private constructor(private val githubDao: GitHubRepoDao) {

    fun getRepos() = githubDao.getRepos()
    fun getRepo(repoId: Int) = githubDao.getRepo(repoId)

    suspend fun refreshRepos(userName: String) {
        withContext(Dispatchers.IO) {
            val list = Network.gitRepo.getRepos(userName).await()
            githubDao.insertAll(list)
        }
    }

    companion object {

        @Volatile private var instance: GitHubRepository? = null

        fun getInstance(githubDao: GitHubRepoDao) =
                instance ?: synchronized(this) {
                    instance ?: GitHubRepository(githubDao).also { instance = it }
                }
    }
}
