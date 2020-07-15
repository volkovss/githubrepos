
package com.githubrepo.githubrepos.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.githubrepo.githubrepos.data.GitHubRepository

class RepoMainViewModelFactory(
    private val gitHubRepository: GitHubRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepoMainViewModel(gitHubRepository) as T
    }
}
