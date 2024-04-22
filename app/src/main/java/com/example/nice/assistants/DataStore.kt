package com.example.nice.assistants

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.nice.templates.UserAuthorizeData
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_store")

class DataStoreManager(val context: Context){
    suspend fun saveAuthorizeData(authorizeData: UserAuthorizeData){
        context.dataStore.edit {pref ->
            pref[stringPreferencesKey("LOGIN")]
            pref[stringPreferencesKey("PASSWORD")]
        }
    }
    fun getAuthorizeData() = context.dataStore.data.map {pref ->
        return@map UserAuthorizeData(
            pref[stringPreferencesKey("LOGIN")] ?: "",
            pref[stringPreferencesKey("PASSWORD")] ?: ""
        )
    }
}