package com.example.nice.navigation

sealed class Screen(val route: String){
    object StartWindow : Screen("startwindow_screen")
    object ProfileWindow : Screen("profilewindow_screen")

    object SignInWindow : Screen("signinwindow_screen/{selectedRole}"){
        fun selectedRole(selectedRole : String) : String{
            return "signinwindow_screen/$selectedRole"
        }
    }
    object SignUpWindow : Screen("signupwindow_screen/{selectedRole}"){
        fun selectedRole(selectedRole : String) : String{
            return "signupwindow_screen/$selectedRole"
        }
    }
}