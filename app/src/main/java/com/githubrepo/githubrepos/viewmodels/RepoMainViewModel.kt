
package com.githubrepo.githubrepos.viewmodels

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.githubrepo.githubrepos.data.GitHubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class RepoMainViewModel(
   private val gitHubRepository: GitHubRepository
) : ViewModel() {

   private val viewModelJob = SupervisorJob()
   private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

   val userName = MutableLiveData<String>()

   fun clearCache() {
      viewModelScope.launch {
         gitHubRepository.clearCache()
      }
   }
}
