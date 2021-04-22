package com.example.battlebuddies.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.battlebuddies.Pet
import com.example.battlebuddies.R

// Global boolean to represent whether the pet is in egg form
var isEgg = true;

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        var pet = Pet(view.findViewById(getResources().getIdentifier("spr_pet", "id", getContext()?.getPackageName())), R.drawable.bird, R.drawable.bird_flap);
        // Array of all the frames of the egg breaking animation
        val spr_egg = arrayOf(R.drawable.eggsprite1, R.drawable.eggsprite2, R.drawable.eggsprite3, R.drawable.eggsprite4, R.drawable.bird);
        // Variable to track how close the egg is to hatching
        var eggHealth = 0;

        // When this fragment starts, check if the pet is an egg or not
        if (isEgg == false) {
            pet.getSprite().setImageResource(R.drawable.bird);
            pet.setAnimation(R.drawable.bird, R.drawable.bird_flap);
            pet.animationStart();
        }
        // Allow user to tap the egg to hatch it
        pet.getSprite().setOnClickListener {
            // Make sure the pet is still an egg
            if (isEgg == true) {
                eggHealth++;
                pet.getSprite().setImageResource(spr_egg[eggHealth]);
                // When the egg is too damaged,
                if (eggHealth >= 4) {
                    // Set isEgg to false signalling that the pet is no longer an egg
                    isEgg = false;
                    // Set image to bird and signal for the animation coroutine to start
                    pet.getSprite().setImageResource(R.drawable.bird);
                    pet.animationStart();
                }
            }
        }
    }
}