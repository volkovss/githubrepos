
package com.githubrepo.githubrepos.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.githubrepo.githubrepos.data.GitHubRepository

class RepoDetailViewModelFactory(
    private val gitHubRepository: GitHubRepository,
    private val repoId: Int
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepoDetailViewModel(gitHubRepository, repoId) as T
    }
}
