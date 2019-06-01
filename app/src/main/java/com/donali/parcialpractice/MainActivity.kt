package com.donali.parcialpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.donali.parcialpractice.database.models.PokeResult
import com.donali.parcialpractice.database.viewmodels.PokeResultViewModel
import com.donali.parcialpractice.helpers.ActivityHelper

class MainActivity : AppCompatActivity(),ActivityHelper {



    lateinit var pokeResultViewModel: PokeResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pokeResultViewModel = ViewModelProviders.of(this).get(PokeResultViewModel::class.java)
        val listFragment = ListFragment()
        supportFragmentManager.beginTransaction().add(R.id.fl_main, listFragment).commit()

        /*pokeResultViewModel = ViewModelProviders.of(this).get(PokeResultViewModel::class.java)
        pokeResultViewModel.getAllPokeResults().observe(this, Observer {
            pokeResultList = it
        })


        pokeResultViewModel.retreivePokeResults()*/


    }

    override fun getLayoutManager(): RecyclerView.LayoutManager = LinearLayoutManager(this)

    override fun getSharedViewModel(): PokeResultViewModel = pokeResultViewModel
    override fun getCustomSupportFragmentManager(): FragmentManager = supportFragmentManager
}
