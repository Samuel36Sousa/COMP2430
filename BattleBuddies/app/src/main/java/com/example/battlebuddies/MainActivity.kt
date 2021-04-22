package com.example.battlebuddies

import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Pet class manages animations and stats for your pet
// This class is stored in MainActivity but imported and used in other classes
open class Pet constructor(iv: ImageView, vararg frames: Int) {
    // Animation related variables
    private var imageView = iv;
    private var frames = frames;
    private var image_speed = 500L;
    private var image_index = 0;
    private var maxFrames = frames.size;

    // Animation related accessors
    fun getSprite() : ImageView {
        return imageView;
    }

    fun getFrame() : Int {
        return image_index;
    }

    fun setFrame(frame: Int) {
        this.image_index = frame;
    }

    fun setAnimation(vararg frames: Int) {
        this.frames = frames;
        this.maxFrames = frames.size;
    }

    // Function to start animation coroutine
    fun animationStart() {
        GlobalScope.launch {
            while (true) {
                delay(image_speed);
                imageView.setImageResource(frames[image_index]);
                if (++image_index == maxFrames) {
                    image_index = 0;
                }
            }
        }
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}