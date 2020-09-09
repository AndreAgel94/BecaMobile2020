package com.example.becamobile2020.presentation.heroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.becamobile2020.R

class HeroesAdapter (): RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): HeroesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {

    }

    class HeroesViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }
}