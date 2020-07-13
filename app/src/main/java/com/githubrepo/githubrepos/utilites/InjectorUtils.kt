
package com.githubrepo.githubrepos.utilites

import android.content.Context
import com.githubrepo.githubrepos.data.AppDatabase
import com.githubrepo.githubrepos.data.GitHubRepository
import com.githubrepo.githubrepos.viewmodels.RepoDetailViewModelFactory
import com.githubrepo.githubrepos.viewmodels.RepoListViewModelFactory
import com.githubrepo.githubrepos.viewmodels.RepoMainViewModelFactory

object InjectorUtils {

    private fun getRepoRepository(context: Context): GitHubRepository {
        return GitHubRepository.getInstance(
                AppDatabase.getInstance(context.applicationContext).githubRepoDao())
    }

    fun provideMainViewModelFactory(context: Context): RepoMainViewModelFactory {
        return RepoMainViewModelFactory()
    }

    fun provideRepoListViewModelFactory(
        context: Context,
        userName: String
    ): RepoListViewModelFactory {
        val repository = getRepoRepository(context)
        return RepoListViewModelFactory(repository,userName)
    }

    fun provideRepoDetailViewModelFactory(
        context: Context,
        repoId: Int
    ): RepoDetailViewModelFactory {
        return RepoDetailViewModelFactory(getRepoRepository(context)
            ,repoId)
    }
}
