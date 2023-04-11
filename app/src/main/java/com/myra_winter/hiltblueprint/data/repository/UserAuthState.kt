package com.myra_winter.hiltblueprint.data.repository

/**
 * This class is to manage the different User States: login, logout, onboarding and unknown as default
 * */
enum class UserState {
    HOME,
    LOGIN,
    LOGOUT,
    SIGN_UP,
    ONBOARDING
}

/**
 * This class gets the User state string
 * */
fun userStateString (currentUserState: UserState): String {
    return when (currentUserState) {
        UserState.HOME -> "HOME"
        UserState.LOGIN -> "LOGIN"
        UserState.LOGOUT -> "LOGOUT"
        UserState.SIGN_UP -> "SIGN_UP"
        UserState.ONBOARDING -> "ONBOARDING"
    }
}