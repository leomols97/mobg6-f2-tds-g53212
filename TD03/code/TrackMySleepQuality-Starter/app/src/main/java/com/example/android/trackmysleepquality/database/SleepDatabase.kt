package com.example.android.trackmysleepquality.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {}