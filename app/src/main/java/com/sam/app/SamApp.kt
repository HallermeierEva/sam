package com.sam.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sam.ui.onboarding.LanguagePickerScreen
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
                onSplashComplete = { navController.navigate("language") }
            )
        }
        composable("language") {
            LanguagePickerScreen(
                onLanguageSelected = { language ->
                    // TODO: handle language selection in ViewModel
                    navController.navigate("persona")
                }
            )
        }
        composable("persona") {
            PersonaPickerScreen(
                onPersonaSelected = { persona ->
                    // TODO: handle persona selection
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
            ProactivityScreen(
                onProactivitySelected = { enabled ->
                    // TODO: handle proactivity
                    navController.navigate("home")
                }
            )
        }
        composable("home") {
            // Placeholder for main home screen
        }
    }
}
