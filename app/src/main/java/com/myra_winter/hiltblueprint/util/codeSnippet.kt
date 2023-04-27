package com.myra_winter.hiltblueprint.util

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

// when values should change: eiter
@Composable
fun ExampleA() {
    var text by remember { mutableStateOf("") }

    ExampleB(
        text = text,
        onChange = { newText ->
            text = newText
        }
    )
}

@Composable
fun ExampleB(
    text: String,
    onChange: (String) -> Unit
) {
    TextField(value = text, onValueChange = { onChange(it) })
}

// or
@Composable
fun TestComposeA(){
    val taskVeriable = remember {mutableStateOf("Hello World")}
    TestComposeB(taskVeriable)
}

@Composable
fun TestComposeB(taskVeriable : MutableState<String>){
    taskVeriable.value = "New Value"
}
// TODO check out state and ViewModel!!


@Composable
fun scrollableColumnWithoutLazy(){
    Column() {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false) // -> this needs the second Column

        ) {
            Text("Just some example text")
        }
    }
}


