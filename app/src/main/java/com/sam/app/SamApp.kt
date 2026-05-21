package com.sam.app

import android.content.Intent
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sam.app.service.CommuteService
import com.sam.ui.home.HomeScreen
import com.sam.ui.onboarding.LanguagePickerScreen
import com.sam.ui.onboarding.OnboardingViewModel
import com.sam.ui.onboarding.PermissionsScreen
import com.sam.ui.onboarding.PersonaPickerScreen
import com.sam.ui.onboarding.ProactivityScreen
import com.sam.ui.onboarding.SplashScreen

@Composable
fun SamApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(
                onSplashComplete = {
                    navController.navigate("language") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }
        composable("language") {
            val viewModel: OnboardingViewModel = hiltViewModel()
            LanguagePickerScreen(
                onLanguageSelected = { language ->
                    viewModel.setLanguage(language)
                    navController.navigate("persona")
                }
            )
        }
        composable("persona") {
            val viewModel: OnboardingViewModel = hiltViewModel()
            PersonaPickerScreen(
                onPersonaSelected = { persona ->
                    viewModel.setPersona(persona)
                    navController.navigate("permissions")
                }
            )
        }
        composable("permissions") {
            PermissionsScreen(
                onPermissionsGranted = { navController.navigate("proactivity") }
            )
        }
        composable("proactivity") {
            val viewModel: OnboardingViewModel = hiltViewModel()
            ProactivityScreen(
                onProactivitySelected = { enabled ->
                    viewModel.setProactivity(enabled)
                    viewModel.completeOnboarding()
                    navController.navigate("home") {
                        popUpTo("language") { inclusive = true }
                    }
                }
            )
        }
        composable("home") {
            val context = LocalContext.current
            LaunchedEffect(Unit) {
                val serviceIntent = Intent(context, CommuteService::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    context.startForegroundService(serviceIntent)
                } else {
                    context.startService(serviceIntent)
                }
            }
            HomeScreen()
        }
    }
}
