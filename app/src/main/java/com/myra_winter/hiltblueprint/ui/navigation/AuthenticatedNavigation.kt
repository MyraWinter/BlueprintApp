package com.myra_winter.hiltblueprint.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.myra_winter.hiltblueprint.ui.books.BookScreen
import com.myra_winter.hiltblueprint.ui.home.HomeScreen




//        composable(
//            NavigationItem.Books.Details.route + "/{selected}",
//            arguments = listOf(navArgument("selected") { type = NavType.IntType })
//        ) { backStackEntry ->
//            Log.i("NAVIGATION", "Is this called?")
//
//            backStackEntry.arguments?.getInt("selected")?.let { bookId ->
//                // get selected book here or better in viewModel? -> viewModel instead of Int a BookDbExample element should be transferred if possible
//                val specificBook = bookSamples.first {
//                    it.id == bookId
//                }
//                BooksDetailScreen(specificBook)
//            }
//        }