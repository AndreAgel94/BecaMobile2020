package com.example.becamobile2020.presentation.heroes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.becamobile2020.R
import com.example.becamobile2020.data.response.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroesAdapter (
   private val heroesList : List<Character>
): RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): HeroesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {

        holder.itemView.textHeroName.text = heroesList[position].name

        var thumbnail = "${heroesList[position].thumbnail.path}/standard_medium.${heroesList[position].thumbnail.extension}"
            .split(":")

        Picasso.get().load("https:"+thumbnail[1]).into(holder.itemView.imageHero)

    }

    class HeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        private val heroName = itemView.textHeroName
        private val heroImg : ImageView = itemView.imageHero


    }
}