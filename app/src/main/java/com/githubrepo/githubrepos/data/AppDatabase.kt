package com.githubrepo.githubrepos.data

import android.content.Context
import androidx.room.*
import com.githubrepo.githubrepos.utilites.DATABASE_NAME
import java.util.*

@Database(entities = [GitHubRepo::class,Owner::class], version = 10, exportSchema = false)
@TypeConverters(Converters::class)
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

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        var res: Date? = null
        if (value != null) res = Date(value)
        return res
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        var res: Long? = null
        if (date != null) res = date.getTime()
        return res
    }
}