package com.githubrepo.githubrepos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.githubrepo.githubrepos.data.GitHubRepo
import com.githubrepo.githubrepos.data.GitHubRepository

class RepoListViewModel internal constructor(gitHubRepository: GitHubRepository) : ViewModel() {

    val repos: LiveData<List<GitHubRepo>> =
        gitHubRepository.getRepos()
}
