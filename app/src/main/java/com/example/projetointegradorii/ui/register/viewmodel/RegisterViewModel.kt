package com.example.projetointegradorii.ui.register.viewmodel

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetointegradorii.domain.model.User
import com.example.projetointegradorii.domain.repository.AuthRepository
import com.example.projetointegradorii.utils.COLLISION
import com.example.projetointegradorii.utils.EMPTY
import com.example.projetointegradorii.utils.ERROR
import com.example.projetointegradorii.utils.WEAK
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class RegisterViewModel: ViewModel()  {
    private val repository = AuthRepository()

    private var _register = MutableLiveData<User>()
    var register: LiveData<User> = _register

    private var _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    fun validate(name: EditText, email: EditText, pass: EditText){
        if(name.text.isEmpty() || email.text.isEmpty() || pass.text.isEmpty()){
            name.error = EMPTY
            email.error = EMPTY
            pass.error = EMPTY
        } else{
            register(User(name = name.text.toString(), email = email.text.toString(), password = pass.text.toString()))
        }
    }
    private fun register(user: User){
        try {
            repository.register(user.name, user.email, user.password)
            _register.value = user
        }catch(e: FirebaseAuthWeakPasswordException){
            _error.value = WEAK
        }catch(e: FirebaseAuthUserCollisionException){
            _error.value = COLLISION
        }catch(e: Exception){
            _error.value = ERROR
            Log.i("TAG LOG", _error.value.toString())
        }
    }
}