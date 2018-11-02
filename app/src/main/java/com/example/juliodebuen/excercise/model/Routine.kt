package com.example.juliodebuen.excercise.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Routine")
class Routine(@PrimaryKey(autoGenerate = true) var id: Long?,
              @ColumnInfo(name = "name") var name: String?,
              @ColumnInfo(name = "dayOfWeek") var dayOfWeek: String?) {

    constructor():this(null, "", "")
}