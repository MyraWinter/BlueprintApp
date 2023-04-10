package com.myra_winter.hiltblueprint.data.repository

enum class UserState {
    AUTHENTICATED,
    UNAUTHENTICATED,
    ONBOARDING,
    UNKNOWN
}
fun UserStateString (currentUserState: UserState): String {
    return when (currentUserState) {
        UserState.AUTHENTICATED -> "authenticated"
        UserState.UNAUTHENTICATED -> "unauthenticated"
        UserState.ONBOARDING -> "onboarding"
        UserState.UNKNOWN -> "unknown"
    }
}