package com.os.casts.ui.features.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.os.casts.ui.features.intro.IntroActivity
import com.os.casts.ui.features.main.MainActivity
import com.os.casts.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EntryActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        val activity = if (preferences.getIntro()) MainActivity::class.java else IntroActivity::class.java
        val intent = Intent(this, activity)
        startActivity(intent)
        finish()
    }
}