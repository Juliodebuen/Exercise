package com.example.juliodebuen.excercise.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.juliodebuen.excercise.model.Exercise
import com.example.juliodebuen.excercise.model.Routine

@Dao
interface RoutineDao {
    @Query("SELECT *  FROM Routine")
    fun getAll(): List<Routine>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(routine: Routine) : Long

    @Insert
    fun insertMany(vararg routine : Routine) : List<Long>

    @Query("DELETE FROM Routine")
    fun deleteAll()
}