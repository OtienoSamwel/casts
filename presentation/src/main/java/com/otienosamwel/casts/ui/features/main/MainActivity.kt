package com.otienosamwel.casts.ui.features.main

import android.content.ComponentName
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.common.util.concurrent.MoreExecutors
import com.otienosamwel.casts.R.drawable
import com.otienosamwel.casts.player.PlaybackService
import com.otienosamwel.casts.ui.features.home.Home
import com.otienosamwel.casts.ui.theme.CastTheme
import com.otienosamwel.data.models.Result
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    companion object {
        private val TAG = MainActivity::class.simpleName ?: "MainActivity"
    }

    private var mediaController: MediaController? = null

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

    override fun onStart() {
        super.onStart()

        val sessionToken = SessionToken(this, ComponentName(this, PlaybackService::class.java))
        val controllerFuture = MediaController.Builder(this, sessionToken).buildAsync()
        controllerFuture.addListener({
            mediaController = controllerFuture.get()
        }, MoreExecutors.directExecutor())
    }

    private fun onPodcastClicked(podCast: Result) {
        Log.i(TAG, "onPodcastClicked: link -> ${podCast.audio}")
        mediaController?.let { controller ->
            val mediaItem = MediaItem.fromUri(podCast.audio!!)
            controller.setMediaItem(mediaItem)
            controller.prepare()
            controller.play()
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
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.name
                    )
                },
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
