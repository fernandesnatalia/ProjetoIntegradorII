package com.example.projetointegradorii.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.ktx.Firebase

class AuthRepository {
    private val auth: FirebaseAuth = Firebase.auth
    private val database = FirebaseDatabase.getInstance()
    private val ref = database.getReference()

    fun getEmail() : String = auth.currentUser?.email.toString()

    fun register(name: String, email: String, password: String) : Task<AuthResult> {
        ref.child("name").ref.setValue(name)
        return auth.createUserWithEmailAndPassword(email, password)
    }


    fun login(email: String, password: String) : Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
    }

    fun logout() {
        auth.signOut()
    }

    fun getUserId(): String? {
        return FirebaseAuth.getInstance().currentUser?.uid
    }

    fun databaseReference() = ref

    fun getUserMessages(): Query {
        return ref.orderByValue()
    }
}