package com.example.juliodebuen.excercise.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.juliodebuen.excercise.model.Exercise

@Dao
interface ExerciseDao {
    @Query("SELECT *  FROM Exercise")
    fun getAll(): List<Exercise>

    @Insert(onConflict = REPLACE)
    fun insert(exercise: Exercise) : Long

    @Insert
    fun insertMany(vararg exercises : Exercise) : List<Long>

    @Query("DELETE FROM Exercise")
    fun deleteAll()
}