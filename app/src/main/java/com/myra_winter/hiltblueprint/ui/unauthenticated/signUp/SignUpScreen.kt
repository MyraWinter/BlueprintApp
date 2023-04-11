package com.myra_winter.hiltblueprint.ui.unauthenticated.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.myra_winter.hiltblueprint.data.repository.UserState

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = hiltViewModel(),
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SignUpScreen",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
        Button(onClick = {

            // TODO -> this triggers HiltViewModel and navigates to Login instead of Home in on Click
            // maybe call this in Home?
            signUpViewModel.saveOnBoardingState(UserState.LOGIN)
            onClick()
        }
        ) {
            Text(
                text = "SignUp",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
@Preview
fun SignUpScreenPreview() {
    MaterialTheme {
        SignUpScreen(onClick = {})
    }
}