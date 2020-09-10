package com.example.becamobile2020.presentation.heroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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
        private val heroImg : ImageView = itemView.imageHero


        fun bindView(hero:Hero){
            var url : String = hero.heroimage
            heroName.text = hero.name

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .load(url)
                .into(heroImg)

        }
    }
}