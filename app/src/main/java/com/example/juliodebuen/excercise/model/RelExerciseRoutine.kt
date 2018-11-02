package com.example.juliodebuen.excercise.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "RelExerciseRoutine")
class RelExerciseRoutine(@PrimaryKey(autoGenerate = true) var id : Long?,
                         @ColumnInfo(name = "ExerciseId") var exerciseId: Long?,
                         @ColumnInfo(name = "RoutineId") var routineId: Long?) {
    constructor():this(null, 0, 0)
}