package com.myra_winter.hiltblueprint.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


// https://proandroiddev.com/preference-datastore-the-generic-way-d26b11f1075f
// https://medium.com/androiddevelopers/all-about-preferences-datastore-cc7995679334
// https://www.youtube.com/watch?v=kp53qL_O5gk&t=32s -> Codelab https://developer.android.com/codelabs/android-preferences-datastore#6
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "on_boarding_pref")

class DataStoreRepository(context: Context) {

    private object PreferencesKey {
        val authenticatedKey = stringPreferencesKey(name = "authentication_state")
    }

    private val dataStore = context.dataStore

    suspend fun saveAuthState(userAuthState: UserAuthState) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.authenticatedKey] = userAuthState.state
        }
    }

    fun readAuthState(): Flow<UserAuthState> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                when {
                    preferences[PreferencesKey.authenticatedKey]?.equals(UserAuthState.AUTHENTICATED.state) == true -> {
                        UserAuthState.AUTHENTICATED
                    }
                    preferences[PreferencesKey.authenticatedKey]?.equals(UserAuthState.UNAUTHENTICATED.state) == true -> {
                        UserAuthState.UNAUTHENTICATED
                    }
                    preferences[PreferencesKey.authenticatedKey]?.equals(UserAuthState.ONBOARDING.state) == true -> {
                        UserAuthState.ONBOARDING
                    }
                    else -> {
                        UserAuthState.UNKNOWN
                    }
                }
            }
    }
}