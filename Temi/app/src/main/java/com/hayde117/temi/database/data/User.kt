package com.hayde117.temi.database.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Entity(tableName = "user_table")
@Parcelize
data class User(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val message: String,
    val first_percent: Int,
    val second_percent: Int,
//    val created_date: Long = System.currentTimeMillis(),
): Parcelable
  //  : Parcelable {
//    val createdDateFormatted: String
//        get() = DateFormat.getTimeInstance().format(created_date)
//}
