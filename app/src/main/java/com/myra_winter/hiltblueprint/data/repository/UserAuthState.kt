package com.myra_winter.hiltblueprint.data.repository

sealed class UserAuthState(val state: String) {

    object AUTHENTICATED : UserAuthState(state = "authenticated")
    // This will currently not be implemented, could be in a later state with Setup Account and Everything
    // currently this is only a App without Login, but the possibility to implement one
    object UNAUTHENTICATED : UserAuthState(state = "unauthenticated")
    object ONBOARDING : UserAuthState(state = "onboarding")
    object UNKNOWN : UserAuthState(state = "unknown")

}
