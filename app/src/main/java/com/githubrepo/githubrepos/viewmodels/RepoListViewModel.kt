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
        gitHubRepository.getRepos(userName)

    private val _needToShowDialog = MutableLiveData<Boolean>().apply { value = false }
    val needToShowDialog: LiveData<Boolean>
        get() = _needToShowDialog

    init {
        viewModelScope.launch {
            try {
                gitHubRepository.refreshRepos(userName)
            } catch (e: Exception) {
                if (repos.value == null || repos.value?.size == 0 ) {
                    _needToShowDialog.value = true
                }
            }
        }
    }

    fun resetShowDialog() {
        _needToShowDialog.value = false
    }
}
