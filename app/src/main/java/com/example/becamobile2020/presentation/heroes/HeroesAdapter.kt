package com.example.becamobile2020.presentation.heroes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.becamobile2020.R
import com.example.becamobile2020.data.response.Character
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
        //holder.bind(heroesList[position])
        for (item in heroesList) {

            Log.i("maluco444", item.thumbnail.path +  item.thumbnail.extension)

        }
        (holder as HeroesViewHolder).bind(heroesList[position])


    }

    class HeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        private val heroName = itemView.textHeroName
        private val heroImg : ImageView = itemView.imageHero


        fun bind(hero: Character){

            var thumbnail = hero.thumbnail.path +"/standard_amazing."+hero.thumbnail.extension
            heroName.text = hero.name

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Log.i("maluco333", thumbnail )

                Glide.with(itemView.context)
                .load( "http://i.annihil.us/u/prod/marvel/i/mg/f/60/4c0042121d790/standard_amazing.jpg")
                .into(itemView.imageHero)
              // itemView.imageHero.setBackgroundColor(Color.RED)



            //thumbnail = result.thumbnail.path + "/standard_amazing" + result.thumbnail.extension

        }
    }
}