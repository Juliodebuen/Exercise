package com.example.juliodebuen.excercise.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.juliodebuen.excercise.dao.ExerciseDao
import com.example.juliodebuen.excercise.dao.RelExerciseRoutineDao
import com.example.juliodebuen.excercise.dao.RoutineDao
import com.example.juliodebuen.excercise.model.Exercise
import com.example.juliodebuen.excercise.model.RelExerciseRoutine
import com.example.juliodebuen.excercise.model.Routine

@Database(entities = arrayOf(Exercise::class, Routine::class, RelExerciseRoutine::class), version = 1)
abstract class FullDatabase : RoomDatabase(){
    abstract fun exerciseDao(): ExerciseDao
    abstract fun routineDao() : RoutineDao
    abstract fun relExerciseRoutineDao(): RelExerciseRoutineDao

    companion object {
        private var INSTANCE: FullDatabase? = null

        fun getInstance(context: Context): FullDatabase? {
            if (INSTANCE == null){
                synchronized(FullDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, FullDatabase::class.java, "routine.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}