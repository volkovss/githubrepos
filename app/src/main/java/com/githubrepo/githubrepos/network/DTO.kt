package com.githubrepo.githubrepos.network

import com.githubrepo.githubrepos.data.GitHubRepo
import com.githubrepo.githubrepos.data.Owner
import com.squareup.moshi.*
import java.text.SimpleDateFormat
import java.util.*


data class GitHubRepoJson(
    val id: Int?,
    val name: String?,
    val owner: Owner?,
    @Json(name = "updated_at")
    val updatedAt: Date?,
    val language: String?,
    val watchers: Int?,
    @Json(name = "stargazers_count")
    val stargazers: Int?,
    val forks: Int?
)

class GitHubRepoJsonAdapter {
    @FromJson
    fun gitHubRepoJson(gitHubRepoJson: GitHubRepoJson): GitHubRepo {
        return GitHubRepo(
            gitHubRepoJson.id,
            gitHubRepoJson.name,
            gitHubRepoJson.updatedAt,
            gitHubRepoJson.owner,
            gitHubRepoJson.language,
            gitHubRepoJson.watchers,
            gitHubRepoJson.stargazers,
            gitHubRepoJson.forks
        )
    }
}

data class OwnerJson(
    val id: Int?,
    val login: String?,
    @Json(name = "avatar_url")
    val avatarUrl: String?
)

class OwnerJsonAdapter {
    @FromJson
    fun ownerJson(ownerJson: OwnerJson): Owner {
        return Owner(
            ownerJson.id,
            ownerJson.login,
            ownerJson.avatarUrl
        )
    }
}

class CustomDateAdapter : JsonAdapter<Date>() {
    private val dateFormat = SimpleDateFormat(SERVER_FORMAT, Locale.getDefault())

    @FromJson
    override fun fromJson(reader: JsonReader): Date? {
        return try {
            val dateAsString = reader.nextString()
            dateFormat.parse(dateAsString)
        } catch (e: Exception) {
            null
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: Date?) {
        if (value != null) {
            writer.value(value.toString())
        }
    }

    companion object {
        const val SERVER_FORMAT = ("yyyy-MM-dd'T'HH:mm:ss'Z'")
    }
}

