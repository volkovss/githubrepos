package com.githubrepo.githubrepos.data

import androidx.room.Embedded
import androidx.room.Entity
import java.util.*

@Entity(tableName = "githubrepos", primaryKeys = ["id"])
data class GitHubRepo constructor(
    val id: Int? = 0,
    val name: String? = "",
    val updatedAt: Date?,
    @Embedded(prefix = "owner_")
    val owner: Owner ? = null,
    val language: String? = "",
    val watchers: Int? = 0,
    val stargazers: Int? = 0,
    val forks: Int? = 0,
    val createdAt: Date?,
    val htmlUrl: String? = "",
    val fork: Boolean? = null,
    val description: String? = ""
)

@Entity(tableName = "owners", primaryKeys = ["id"])
data class Owner constructor(
    val id: Int? = 0,
    val login: String? = "",
    val avatarUrl: String? = ""
)

