
package com.githubrepo.githubrepos.network

import com.githubrepo.githubrepos.data.GitHubRepo
import com.githubrepo.githubrepos.utilites.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface GitHubRepoService {
    @GET("repos")
    fun getRepos(): Deferred<List<GitHubRepo>>
}

private val moshi = Moshi.Builder()
        //.add(GitHubRepoJsonAdapter())
        .add(KotlinJsonAdapterFactory())
        .build()

object Network {

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    val gitRepo = retrofit.create(GitHubRepoService::class.java)
}
