package com.githubrepo.githubrepos.network

import com.githubrepo.githubrepos.data.GitHubRepo
import com.githubrepo.githubrepos.data.Owner
import com.squareup.moshi.FromJson

//data class GitHubRepoJson (
//    val id: Int,
//    val name: String,
//    val owner: Owner
//)
//
//class GitHubRepoJsonAdapter {
//    @FromJson
//    fun gitHubRepoJson(gitHubRepoJson: GitHubRepoJson): GitHubRepo {
//        return GitHubRepo(
//            gitHubRepoJson.id,
//            gitHubRepoJson.name,
//            gitHubRepoJson.owner
//        )
//    }
//}

//data class OwnerJson (
//    val id: Int,
//    val login: String
//)
//
//class OwnerJsonAdapter {
//    @FromJson
//    fun ownerJson(ownerJson: OwnerJson): Owner {
//        return Owner(
//            ownerJson.id,
//            ownerJson.login
//        )
//    }
//}