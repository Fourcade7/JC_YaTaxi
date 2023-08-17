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
    suspend fun save(key:String,value:Int) {
        val datastorekey= intPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings[datastorekey]= value
        }
    }
    suspend fun load(key:String): Flow<Int> {
        val datastorekey= intPreferencesKey(key)
        val flow: Flow<Int> =context.dataStore.data
            .map { preferences ->
                // No type safety.
                preferences[datastorekey]?:0
            }

        return flow
    }
}
