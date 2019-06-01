package com.donali.parcialpractice


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.donali.parcialpractice.adapters.PokeResultAdapter
import com.donali.parcialpractice.database.viewmodels.PokeResultViewModel
import com.donali.parcialpractice.helpers.ActivityHelper


/**
 * A simple [Fragment] subclass.
 *
 */
class ListFragment : Fragment() {


    lateinit var pokeResultViewModel: PokeResultViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var activityHelper: ActivityHelper

    lateinit var pokeResultAdapter:PokeResultAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityHelper = context as ActivityHelper
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        pokeResultAdapter = PokeResultAdapter(emptyList(),activityHelper.getSharedViewModel())
        recyclerView = view.findViewById(R.id.rv_poke_list)
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = pokeResultAdapter
            layoutManager = activityHelper.getLayoutManager()
        }
        pokeResultViewModel = activityHelper.getSharedViewModel()
        pokeResultViewModel.retreivePokeResults()
        pokeResultViewModel.getAllPokeResults().observe(this, Observer {
            pokeResultAdapter.setData(it)
        })
        return view
    }


}
