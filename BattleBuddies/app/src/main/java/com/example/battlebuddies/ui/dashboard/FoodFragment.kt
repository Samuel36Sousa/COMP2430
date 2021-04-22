package com.example.battlebuddies.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.battlebuddies.R

class FoodFragment : Fragment() {

    private lateinit var foodViewModel: FoodViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        foodViewModel =
                ViewModelProvider(this).get(FoodViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_food, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        var food: ImageView = view.findViewById(getResources().getIdentifier("pizza", "id", getContext()?.getPackageName()));

        food.setOnClickListener {

        }
    }
}