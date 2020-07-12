package com.githubrepo.githubrepos.data

class GitHubRepository private constructor(private val githubDao: GitHubRepoDao) {

    fun getRepos() = githubDao.getRepos()
    fun getRepo(repoId: Int) = githubDao.getRepo(repoId)

    companion object {

        @Volatile private var instance: GitHubRepository? = null

        fun getInstance(githubDao: GitHubRepoDao) =
                instance ?: synchronized(this) {
                    instance ?: GitHubRepository(githubDao).also { instance = it }
                }
    }
}
