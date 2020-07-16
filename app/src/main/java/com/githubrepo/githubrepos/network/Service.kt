
package com.githubrepo.githubrepos.network

import com.githubrepo.githubrepos.data.GitHubRepo
import com.githubrepo.githubrepos.utilites.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path



interface GitHubRepoService {
    @GET("users/{user_name}/repos")
    fun getRepos(@Path(value = "user_name", encoded = true) userName: String): Deferred<List<GitHubRepo>>
}

private val moshi = Moshi.Builder()
        .add(GitHubRepoJsonAdapter())
        .add(OwnerJsonAdapter())
        .add(KotlinJsonAdapterFactory())
        .add(CustomDateAdapter())
        .build()

object Network {

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    val gitRepo = retrofit.create(GitHubRepoService::class.java)
}

