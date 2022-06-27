package com.hayde117.temi.database.data

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    // Dao must be an interface
    //Dao contains the methods for accessing a DB

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

//    @Query("SELECT * FROM user_table WHERE message LIKE :searchQuery")
//    fun searchDatabase(searchQuery: String): Flow<List<User>>
}