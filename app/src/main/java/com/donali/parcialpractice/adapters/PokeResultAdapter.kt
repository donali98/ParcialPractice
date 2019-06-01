package com.donali.parcialpractice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.donali.parcialpractice.R
import com.donali.parcialpractice.database.models.PokeResult

class PokeResultAdapter(var pokeResults:List<PokeResult>):RecyclerView.Adapter<PokeResultAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeResultAdapter.ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_template,parent,false)
        return ViewHolder(item)
    }

    override fun getItemCount(): Int  = pokeResults.size


    override fun onBindViewHolder(holder: PokeResultAdapter.ViewHolder, position: Int) {
        holder.bind(pokeResults[position])
    }

    fun setData(newPokeResults:List<PokeResult>){
        this.pokeResults = newPokeResults
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var tvPokeName:TextView
        lateinit var tvPokeUrl:TextView
        fun bind(pokeResult: PokeResult) = with(itemView){
            tvPokeName = findViewById(R.id.tv_poke_name)
            tvPokeUrl = findViewById(R.id.tv_poke_url)

            tvPokeName.text = pokeResult.name
            tvPokeUrl.text = pokeResult.url

        }
    }
}