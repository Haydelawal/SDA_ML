package com.hayde117.temi.repository

import com.hayde117.temi.Phonebook
import kotlinx.coroutines.flow.Flow


interface Abstract {

    suspend fun savePhoneBook(phonebook: Phonebook)

    suspend fun getPhoneBook(): Flow<Phonebook>
}