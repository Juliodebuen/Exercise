package com.example.juliodebuen.excercise.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.juliodebuen.excercise.model.RelExerciseRoutine
import com.example.juliodebuen.excercise.model.Routine

@Dao
interface RelExerciseRoutineDao {
    @Query("SELECT *  FROM RelExerciseRoutine")
    fun getAll(): List<RelExerciseRoutine>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(relExerciseRoutine: RelExerciseRoutine) : Long

    @Insert
    fun insertMany(vararg relExerciseRoutine: RelExerciseRoutine) : List<Long>

    @Query("DELETE FROM RelExerciseRoutine")
    fun deleteAll()
}