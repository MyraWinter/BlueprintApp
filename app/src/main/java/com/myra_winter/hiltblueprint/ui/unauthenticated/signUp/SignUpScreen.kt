package com.myra_winter.hiltblueprint.ui.unauthenticated.signUp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.myra_winter.hiltblueprint.data.repository.UserState
import com.myra_winter.hiltblueprint.ui.theme.beige
import com.myra_winter.hiltblueprint.ui.theme.customComponents.CustomBeigeButton
import com.myra_winter.hiltblueprint.ui.theme.customComponents.CustomGradientButton
import com.myra_winter.hiltblueprint.ui.theme.customComponents.CustomOutlinedButton
import com.myra_winter.hiltblueprint.ui.theme.customVerticalGradient
import com.myra_winter.hiltblueprint.ui.theme.customVerticalGradientCut
import com.myra_winter.hiltblueprint.ui.theme.white


@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = hiltViewModel(),
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(brush = customVerticalGradientCut)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        Spacer(modifier = Modifier.weight(0.9f))
        OutlinedTextField(
            textStyle = TextStyle(color = white),
            value = username.value,
            label = { Text(text = "Enter Your Username", color = white) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = white,
                focusedBorderColor = white,
                unfocusedBorderColor = Color.Gray
            ),
            onValueChange = { username.value = it },
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            textStyle = TextStyle(color = white),
            value = password.value,
            label = { Text(text = "Enter Your Password", color = white) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = white,
                focusedBorderColor = white,
                unfocusedBorderColor = Color.Gray
            ),
            onValueChange = { password.value = it },
        )
        Spacer(modifier = Modifier.weight(1f))

        CustomOutlinedButton(
            nameButton = "Sign up",
            onClick = {
                signUpViewModel.saveOnBoardingState(UserState.HOME)
                onClick()
            },
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SignUpScreenPreview() {
    MaterialTheme {
        SignUpScreen(onClick = {})
    }
}

@Composable
fun signUpBox() {
    val username = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(brush = customVerticalGradientCut)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(250.dp)
                .align(Alignment.CenterHorizontally)
                .border(BorderStroke(1.dp, SolidColor(Color.Gray)))
                .background(color = Color.White)
                .width(300.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    label = { Text(text = "Username") },
                    value = username.value,
                    onValueChange = { username.value = it })

                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    label = { Text(text = "Password") },
                    value = password.value,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = { password.value = it })

                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
//                        signUpViewModel.saveOnBoardingState(UserState.HOME)
//                        onClick()
                    }
                ) {
                    Text(
                        text = "SignUp",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive
                    )
                }
            }
        }
    }
}
