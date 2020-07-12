
package com.githubrepo.githubrepos.utilites

import android.content.Context
import com.githubrepo.githubrepos.data.AppDatabase
import com.githubrepo.githubrepos.data.GitHubRepository
import com.githubrepo.githubrepos.viewmodels.RepoDetailViewModelFactory
import com.githubrepo.githubrepos.viewmodels.RepoListViewModelFactory

object InjectorUtils {

    private fun getRepoRepository(context: Context): GitHubRepository {
        return GitHubRepository.getInstance(
                AppDatabase.getInstance(context.applicationContext).githubRepoDao())
    }

    fun provideRepoListViewModelFactory(context: Context): RepoListViewModelFactory {
        val repository = getRepoRepository(context)
        return RepoListViewModelFactory(repository)
    }

    fun provideRepoDetailViewModelFactory(
        context: Context,
        repoId: Int
    ): RepoDetailViewModelFactory {
        return RepoDetailViewModelFactory(getRepoRepository(context)
            ,repoId)
    }
}
