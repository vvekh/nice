package com.example.nice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.nice.screens.StartWindow
import com.example.nice.screens.profile.ProfileWindow
import com.example.nice.screens.sign.SignInWindow
import com.example.nice.screens.sign.SingUpWindow

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination : String = Screen.StartWindow.route
) {
    NavHost(navController = navController,
        startDestination = startDestination
    ){
        composable(Screen.StartWindow.route){
            StartWindow(navController)
        }

        composable(Screen.ProfileWindow.route,
            arguments = listOf(navArgument("activeClient"){
                type = NavType.StringType
                defaultValue = ""
            })){
            val activeClient: String = it.arguments?.getString("activeClient")!!
            ProfileWindow(navController, activeClient)
        }

        composable(Screen.SignInWindow.route,
            arguments = listOf(navArgument("selectedRole"){
                type = NavType.StringType
                defaultValue = ""
            })){
            val selectedRole: String = it.arguments?.getString("selectedRole")!!
            SignInWindow(navController, selectedRole)
        }
        composable(Screen.SignUpWindow.route,
            arguments = listOf(navArgument("selectedRole"){
                type = NavType.StringType
                defaultValue = ""
            })){
            val selectedRole: String = it.arguments?.getString("selectedRole")!!
            SingUpWindow(navController, selectedRole)
        }
    }
}