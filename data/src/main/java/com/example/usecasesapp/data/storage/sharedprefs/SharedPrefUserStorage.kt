package com.example.usecasesapp.data.storage.sharedprefs

import android.content.Context
import com.example.usecasesapp.data.storage.UserStorage
import com.example.usecasesapp.data.storage.models.User

private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val KEY_FIRST_NAME = "KEY_FIRST_NAME"
private const val KEY_LAST_NAME = "KEY_LAST_NAME"
private const val DEFAULT_FIRST_NAME = "FIRST_NAME"
private const val DEFAULT_LAST_NAME = "LAST_NAME"

// data can have reference to context
// data only save info and get info without any logic
class SharedPrefUserStorage(private val context: Context) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)


    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: "$DEFAULT_FIRST_NAME null"
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: "$DEFAULT_LAST_NAME null"
        return User(firstName = firstName, lastName = lastName)
    }
}