package com.myra_winter.hiltblueprint.ui.theme.customComponents

import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.myra_winter.hiltblueprint.ui.theme.white
import com.myra_winter.hiltblueprint.ui.unauthenticated.signUp.GradientButton

//https://stackoverflow.com/questions/64542659/jetpack-compose-custom-textfield-design
@Composable
fun CustomTextInputField(
    labelText:String,
    inputValue: MutableState<TextFieldValue>,
) {
    OutlinedTextField(
        textStyle = TextStyle(
            color = white,
            //textAlign = TextAlign.Center // this places the cursor in the middle
        ),
        value = inputValue.value,
        label = {
            Text(text = labelText, color = white)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = white,
            focusedBorderColor = white,
            unfocusedBorderColor = Color.Gray
        ),
        onValueChange = {
            inputValue.value = it
        },
//         either this or the label, both is to much
//        placeholder = {
//            Text(
//                text = "Username",
//                style = TextStyle(
//                    color = MaterialTheme.colors.primaryVariant,
//                    textAlign = TextAlign.Center
//                )
//            )
//        }
    )

}
@Composable
@Preview
fun ForgotPasswordScreenPreview() {
    val text = rememberSaveable { mutableStateOf(TextFieldValue()) }
    MaterialTheme {
        CustomTextInputField("test label", text)
    }
}
