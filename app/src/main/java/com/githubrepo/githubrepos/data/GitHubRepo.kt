package com.githubrepo.githubrepos.data

import androidx.room.Entity

@Entity(tableName = "githubrepos", primaryKeys = ["id"])
data class GitHubRepo constructor(
    val id: Int,
    val name: String
)
