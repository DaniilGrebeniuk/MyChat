package com.example.mychat.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mychat.presentation.chat.USerScreen
import com.example.mychat.presentation.login.LoginScreen
import com.example.mychat.presentation.login.LoginViewModel
import com.example.mychat.presentation.registration.RegisterScreen
import com.example.mychat.presentation.registration.RegisterViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    loginVm: LoginViewModel,
    registerVm: RegisterViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                vm = loginVm,
                onSuccess = {navController.navigate(Screen.User.route)},
                onRegisterClick = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }
        composable(Screen.Register.route) {
            RegisterScreen(
                vm = registerVm,
                navController = navController,
                onLoginClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.User.route){
            USerScreen()
        }
    }
}