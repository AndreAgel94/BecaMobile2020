package com.example.becamobile2020.presentation.heroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.becamobile2020.R
import com.example.becamobile2020.data.model.Hero
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroesAdapter (
   private val heroesList : List<Hero>
): RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): HeroesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bindView(heroesList[position])
    }

    class HeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val heroName = itemView.textHeroName

        fun bindView(hero:Hero){
            heroName.text = hero.name

        }
    }
}