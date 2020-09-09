package com.example.becamobile2020.presentation.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.becamobile2020.R
import com.example.becamobile2020.data.model.Hero
import kotlinx.android.synthetic.main.activity_heroes.*

class HeroesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        toolbarMain.title = getString(R.string.heroes_title)
        setSupportActionBar(toolbarMain)

        with(recyclerHeroes){
            layoutManager = LinearLayoutManager(this@HeroesActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = HeroesAdapter(getHeroes())
        }
    }

    fun getHeroes() : List<Hero>{
        return listOf<Hero>(
            Hero("spiderman","imgURL")
        )
    }
}