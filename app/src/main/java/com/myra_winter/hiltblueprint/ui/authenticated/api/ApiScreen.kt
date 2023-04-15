package com.myra_winter.hiltblueprint.ui.authenticated.api


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.myra_winter.hiltblueprint.data.model.ElixirModel

@Composable
fun ApiScreen(viewModel: ApiViewModel = hiltViewModel()) {
    val response = viewModel.noteResponseEvent.value


    LaunchedEffect(key1 = true) {
        viewModel.getElexirsFromApi()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "API Tester:",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
        // it will show all notes
        if (response.data.isNotEmpty()) LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(20.dp),
        ) {
            val filterList: List<ElixirModel> = response.data

            items(filterList.size) {
                Text(
                    text = "Elexir: " + filterList[it].name,
                )
            }
        }

        // loading while fetching all notes from server
        if (response.isLoading) Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color.Red)
        }


        // show error
        if (response.error.isNotEmpty()) Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = response.error)
        }


    }
}
