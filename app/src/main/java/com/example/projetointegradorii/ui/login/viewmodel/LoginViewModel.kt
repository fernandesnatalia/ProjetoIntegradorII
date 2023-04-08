package com.example.projetointegradorii.ui.login.viewmodel

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetointegradorii.domain.model.User
import com.example.projetointegradorii.domain.repository.AuthRepository
import com.example.projetointegradorii.utils.EMPTY
import com.example.projetointegradorii.utils.ERROR
import com.example.projetointegradorii.utils.NOT_FOUND
import com.example.projetointegradorii.utils.WEAK
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class LoginViewModel: ViewModel()  {
    private val repository = AuthRepository()
    private var _login = MutableLiveData<User>()
    var login: LiveData<User> = _login
    private var _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    fun validate(email: EditText, pass: EditText){
        if(email.text.isEmpty() || pass.text.isEmpty()){
            email.error = EMPTY
            pass.error = EMPTY
        } else{
            login(User(email = email.text.toString(), password = pass.text.toString()))
        }
    }
    private fun login(user: User){
        try{
            repository.login(user.email,user.password
            ).addOnSuccessListener {
                _login.value = user
            }.addOnFailureListener {
                _error.value = ERROR
            }
        }catch(e: FirebaseAuthInvalidCredentialsException){
            _error.value = WEAK
        }catch(e: FirebaseAuthInvalidUserException){
            _error.value = NOT_FOUND
        }catch(e:Exception){
            _error.value = ERROR
            Log.i("TAG LOG", _error.value.toString())
        }
    }
}