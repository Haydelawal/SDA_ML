package com.hayde117.temi.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hayde117.temi.Phonebook
import com.hayde117.temi.database.data.User
import com.hayde117.temi.database.data.UserDatabase
import com.hayde117.temi.database.data.UserRepository
import com.hayde117.temi.repository.ImplRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.collect


@HiltViewModel
class ActivityViewModel @Inject constructor(private  val implRepository: ImplRepository, application: Application): ViewModel() {

    var phone : MutableLiveData<String> = MutableLiveData("")
    var address : MutableLiveData<String> = MutableLiveData("")
    var name : MutableLiveData<String> = MutableLiveData("")

    var phonebook : MutableLiveData<Phonebook> = MutableLiveData()


    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    ///// me

    fun showTheData(): LiveData<Phonebook> {
        return phonebook
    }

    /////
    fun saveData(){
        viewModelScope.launch(Dispatchers.IO) {
            implRepository.savePhoneBook(
                Phonebook(
                    phone = phone.value!!,
                    address = address.value!!,
                    name = name.value!!
                )
            )
        }
    }

    fun retrieveDate(){
        viewModelScope.launch(Dispatchers.IO) {
            implRepository.getPhoneBook().collect {
                phonebook.postValue(it)
            }
        }
    }

    //////////////////////////


    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)

        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)

        }
    }


    fun deleteALlUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()

        }
    }
}