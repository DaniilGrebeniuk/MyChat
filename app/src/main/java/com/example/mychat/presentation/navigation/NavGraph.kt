package com.example.mychat.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mychat.di.Injection
import com.example.mychat.presentation.chat.ChatScreen
import com.example.mychat.presentation.users.UserScreen
import com.example.mychat.presentation.login.LoginScreen
import com.example.mychat.presentation.login.LoginViewModel
import com.example.mychat.presentation.registration.RegisterScreen
import com.example.mychat.presentation.registration.RegisterViewModel
import com.example.mychat.presentation.users.UsersViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    loginVm: LoginViewModel,
    registerVm: RegisterViewModel,


    ) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                vm = loginVm,
                onSuccess = { navController.navigate(Screen.User.route) },
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
        composable(Screen.User.route) {
            UserScreen(
                navController = navController,
            )
        }
        composable(Screen.Chat.route,
            arguments = listOf(navArgument("userId"){type = NavType.IntType})
            ) { ChatScreen() }

    }
}