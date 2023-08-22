package com.pr7.jc_yataxi.ui.data.pref


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class DataStoreManager constructor(val context: Context) {
    suspend fun saveInt(key:String,value:Int) {
        val datastorekey= intPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings[datastorekey]= value
        }
    }
    suspend fun loadInt(key:String): Flow<Int> {
        val datastorekey= intPreferencesKey(key)
        val flow: Flow<Int> =context.dataStore.data
            .map { preferences ->
                // No type safety.
                preferences[datastorekey]?:0
            }

        return flow
    }

    suspend fun saveString(key:String,value:String) {
        val datastorekey= stringPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings[datastorekey]= value
        }
    }

    suspend fun loadString(key:String): Flow<String?> {
        val datastorekey= stringPreferencesKey(key)
        val flow: Flow<String?> =context.dataStore.data
            .map { preferences ->
                // No type safety.
                preferences[datastorekey]?:null
            }

        return flow
    }
}
