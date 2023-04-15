package com.myra_winter.hiltblueprint.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * DataStore
 *
 * Learning Resources
 * https://proandroiddev.com/preference-datastore-the-generic-way-d26b11f1075f
 * https://medium.com/androiddevelopers/all-about-preferences-datastore-cc7995679334
 * https://www.youtube.com/watch?v=kp53qL_O5gk&t=32s -> Codelab https://developer.android.com/codelabs/android-preferences-datastore#6
 */

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "on_boarding_pref")

class DataStoreRepository(context: Context) {

    private object PreferencesKey {
        val authenticatedKey = stringPreferencesKey(name = "authentication_state")
    }

    private val dataStore = context.dataStore

    suspend fun saveUserState(userState: UserState) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.authenticatedKey] = userStateString(userState)
        }
    }

    fun getUserState(): Flow<UserState> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) emit(emptyPreferences()) else throw exception
            }
            .map { preferences ->
                when (preferences[PreferencesKey.authenticatedKey]) {
                    userStateString(UserState.HOME) -> UserState.HOME
                    userStateString(UserState.LOGIN) -> UserState.LOGIN
                    userStateString(UserState.SIGN_UP) -> UserState.SIGN_UP
                    userStateString(UserState.LOGOUT) -> UserState.LOGOUT
                    userStateString(UserState.ONBOARDING) -> UserState.ONBOARDING
                    else -> UserState.ONBOARDING
                }
            }
    }
}