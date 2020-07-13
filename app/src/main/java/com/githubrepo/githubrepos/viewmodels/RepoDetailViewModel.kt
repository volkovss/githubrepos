
package com.githubrepo.githubrepos.viewmodels

import androidx.lifecycle.ViewModel
import com.githubrepo.githubrepos.data.GitHubRepository

class RepoDetailViewModel(
    repoRepository: GitHubRepository,
    private val repoId: Int
) : ViewModel() {

    val repo = repoRepository.getRepo(repoId)

}
