package com.githubrepo.githubrepos.data

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "githubrepos", primaryKeys = ["id"])
data class GitHubRepo constructor(
    val id: Int? = 0,
    val name: String? = "",
    @Embedded(prefix = "owner_")
    val owner: Owner ? = null
)

@Entity(tableName = "owners", primaryKeys = ["id"])
data class Owner constructor(
    val id: Int? = 0,
    val login: String? = ""
)

