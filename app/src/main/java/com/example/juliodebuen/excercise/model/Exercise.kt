package com.example.juliodebuen.excercise.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.Entity
import android.graphics.Bitmap


@Entity(tableName = "Exercise")
data class Exercise(@PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "image") var image: ByteArray?){
    constructor():this(null, "", "", null)
}