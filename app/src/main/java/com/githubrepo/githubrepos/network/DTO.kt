package com.githubrepo.githubrepos.network

import com.githubrepo.githubrepos.data.GitHubRepo
import com.squareup.moshi.FromJson

data class GitHubRepoJson (
    val id: Int,
    val name: String
)

class GitHubRepoJsonAdapter {
    @FromJson
    fun gitHubRepoJson(gitHubRepoJson: GitHubRepoJson): GitHubRepo {
        return GitHubRepo(
            1,
            "test"
        )
    }
}