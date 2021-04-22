package com.example.battlebuddies.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.math.MathUtils.clamp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.battlebuddies.Pet
import com.example.battlebuddies.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.random.Random

// Global variables
private lateinit var bars: FrameLayout;
// Difficulty is the speed of the bars in pixels per frame
private var difficulty = 10f;

// GamePet inherits the Pet class but adds mini game specific properties such as gravity and movement
class GamePet(iv: ImageView, fl: FrameLayout, sv: TextView, vararg frames: Int) : Pet(iv, *frames) {
    private var vspeed = 0.0f;
    private val gravity = 0.9f;
    private val maxGravity = 35f;
    private var frameLayout: FrameLayout = fl;
    private var scoreView: TextView = sv;
    private var score = 0;

    // Flap function
    fun flap() {
        vspeed = -25f;
    }

    fun startGame() {
        // Start game's simple physics simulation
        GlobalScope.launch {
            while (true) {
                // Delay 17ms so that physics code runs ~60 times per second
                delay(17L);

                // Pet code
                // Apply gravity to vspeed, capped at maxGravity
                if (vspeed < maxGravity) {
                    vspeed += gravity;
                }
                else {
                    vspeed = maxGravity;
                }
                // Update Y position based on vspeed
                frameLayout.setY(frameLayout.getY() + vspeed);
                // Clamp Y within screen bounds
                frameLayout.setY(clamp(frameLayout.getY().toDouble(), -100.0, 1400.0).toFloat());


                // Bars code
                // Move bars to the left
                bars.setX(bars.getX() - difficulty);
                // Check if bars have gone off screen
                if (bars.getX() <= -700f) {
                    // Reset bars x and randomize bars y
                    bars.setX(900f);
                    bars.setY(Random.nextFloat() * 800f - 350f);
                    // Increase difficulty slightly each time you pass an obstacle
                    difficulty += 0.5f;
                    // Increase score by 1
                    scoreView.setText("Score: " + ++score);
                }


                // Check if bird is colliding with bars
                var deltaX = abs(frameLayout.getX() - bars.getX());
                if (deltaX < 30 && (frameLayout.getY() < (bars.getY() + 200) || frameLayout.getY() > (bars.getY() + 1100))) {
                    // Code to show game over and reset game to play again
                    // Reset difficulty
                    difficulty = 10f;
                    // Reset score
                    score = 0;
                    scoreView.setText("Score:" + score);
                    // Reset bars position
                    bars.setX(900f);
                }
            }
        }
    }
}

class NotificationsFragment : Fragment() {

    private lateinit var gameViewModel: GameViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        gameViewModel =
                ViewModelProvider(this).get(GameViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_game, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Here is the main code for the flapping bird mini game
        difficulty = 10f;

        // Set up score textView
        var scoreView : TextView = view.findViewById(getResources().getIdentifier("txt_score", "id", getContext()?.getPackageName()));
        // Get the frameLayout id
        var frameLayout : FrameLayout = view.findViewById(getResources().getIdentifier("framelayout", "id", getContext()?.getPackageName()));
        // Create a Pet called bird
        var bird = GamePet(view.findViewById(getResources().getIdentifier("spr_pet", "id", getContext()?.getPackageName())), frameLayout, scoreView, R.drawable.bird, R.drawable.bird_flap);

        // Get bars resource
        bars = view.findViewById(getResources().getIdentifier("barsLayout", "id", getContext()?.getPackageName()));
        bars.setX(900f);
        // Call function to start game simulation instantly
        bird.startGame();
        // Call function to start pet animation
        bird.animationStart();

        // Set up flap button
        var flapButton : Button = view.findViewById(getResources().getIdentifier("btn_flap", "id", getContext()?.getPackageName()));
        // Set up flap onClickListener
        flapButton.setOnClickListener {
            bird.flap();
        }
    }
}