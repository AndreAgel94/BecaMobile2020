package com.example.becamobile2020.presentation.acivitys


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.becamobile2020.R
import com.example.becamobile2020.data.database.entity.HeroEntity
import com.example.becamobile2020.data.response.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroesAdapter(
    private val heroesList: List<HeroEntity>,
    private val OnItemClickListener: ((character: HeroEntity) -> Unit)
) : RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): HeroesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroesViewHolder(itemView, OnItemClickListener)
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {

        holder.bind(heroesList[position])
    }

    class HeroesViewHolder(
        itemView: View,
        private val OnItemClickListener: (character: HeroEntity) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val heroName = itemView.textHeroName

        fun bind(char: HeroEntity) {
            heroName.text = char.name

            val url = "${char.path}/standard_medium.${char.extension}"
                .split(":")
            Picasso.get().load("https:" + url[1]).into(itemView.imageHero)


            itemView.setOnClickListener {
                OnItemClickListener.invoke(char)
            }

        }

    }
}