package com.githubrepo.githubrepos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.githubrepo.githubrepos.data.GitHubRepo
import com.githubrepo.githubrepos.data.GitHubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class RepoListViewModel(
    gitHubRepository: GitHubRepository,
    private val userName: String
) : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val repos: LiveData<List<GitHubRepo>> =
        gitHubRepository.getRepos()

    init {
        viewModelScope.launch {
            gitHubRepository.refreshRepos(userName)
        }

    }
}
