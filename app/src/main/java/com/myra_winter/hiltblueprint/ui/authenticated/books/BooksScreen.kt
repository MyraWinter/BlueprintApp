package com.myra_winter.hiltblueprint.ui.authenticated.books

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.myra_winter.hiltblueprint.ui.theme.customComponents.ListDivider
import com.myra_winter.hiltblueprint.util.showToast
import kotlinx.coroutines.delay

@Composable
fun BookScreen() {
    val context = LocalContext.current
//    context.showToast("just a message")

    var isLoading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = true) {
        delay(3000)
        isLoading = false
    }
    // Call Shimmer effect using Jetpack Compose
    ShimmerEffectListView(isLoading)
}


@Composable
fun ShimmerEffectListView(isLoading: Boolean) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(20) {
            ShimmerItem(
                isLoading = isLoading,
                actualContent = { ActualContent() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            ListDivider()
        }
    }
}


/**
 * Actual Listview that you want to display once shimmer goes out
 */
@Composable
fun ActualContent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "This is a  text to show that our shimmer loading effect " + "is looking good",
            modifier = Modifier.align(CenterVertically)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BookScreenPreview() {
    MaterialTheme {
        BookScreen()
    }
}