package com.githubrepo.githubrepos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.githubrepo.githubrepos.utilites.DATABASE_NAME

@Database(entities = [GitHubRepo::class,Owner::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun githubRepoDao(): GitHubRepoDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
