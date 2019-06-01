package com.donali.parcialpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.donali.parcialpractice.database.viewmodels.PokeResultViewModel

class MainActivity : AppCompatActivity() {

    lateinit var pokeResultViewModel: PokeResultViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pokeResultViewModel = ViewModelProviders.of(this).get(PokeResultViewModel::class.java)
        pokeResultViewModel.retreivePokeResults()
    }
}
