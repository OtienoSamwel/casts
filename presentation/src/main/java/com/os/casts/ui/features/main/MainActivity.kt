package com.os.casts.ui.features.main

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.os.casts.R.drawable
import com.os.casts.ui.features.home.Home
import com.os.casts.ui.theme.CastTheme
import com.otienosamwel.data.models.Result
import com.otienosamwel.domain.playback.PlaybackService
import com.otienosamwel.domain.playback.PlaybackServiceBinder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CastTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation(this::onPodcastClicked)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(PlaybackServiceConnection)
    }


    private object PlaybackServiceConnection : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            Log.i(TAG, "onServiceConnected: ${(p1 as PlaybackServiceBinder).getService()}")
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
        }
    }

    companion object {
        private const val TAG = "MAIN ACTIVITY"
    }

    private fun onPodcastClicked(podCast: Result) {
        val intent = Intent(this, PlaybackService::class.java)
        intent.action = podCast.audio!!

        try {
            startService(intent)
            bindService(intent, PlaybackServiceConnection, Context.BIND_AUTO_CREATE)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

@Composable
fun Navigation(onPodcastClicked: (Result) -> Unit) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController = navController) }) {
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(it)
        ) {
            composable(route = "home") { Home(onPodcastClicked = onPodcastClicked) }
            composable(route = "discover") {}
            composable(route = "library") {}
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        myScreens.forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = screen.name) },
                label = { Text(text = screen.name, modifier = Modifier.padding(vertical = 8.dp)) },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


sealed class Screen(val name: String, val icon: Int, val route: String) {
    object Home : Screen(name = "Home", icon = drawable.ic_home, route = "home")
    object Discover : Screen(name = "Discover", icon = drawable.ic_compass, route = "discover")
    object Account : Screen(name = "Library", icon = drawable.ic_library, route = "library")
}

val myScreens = listOf(Screen.Home, Screen.Discover, Screen.Account)
