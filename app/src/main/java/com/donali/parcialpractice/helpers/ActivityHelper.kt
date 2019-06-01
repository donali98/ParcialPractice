package com.donali.parcialpractice.helpers

import androidx.recyclerview.widget.RecyclerView
import com.donali.parcialpractice.database.viewmodels.PokeResultViewModel

interface ActivityHelper {
    fun getLayoutManager():RecyclerView.LayoutManager
    fun getSharedViewModel():PokeResultViewModel
}