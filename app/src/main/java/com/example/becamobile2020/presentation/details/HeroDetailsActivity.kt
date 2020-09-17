package com.example.becamobile2020.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.becamobile2020.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hero_details.*
import kotlinx.android.synthetic.main.item_hero.*
import kotlinx.android.synthetic.main.item_hero.view.*


class HeroDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_details)

        toolbarDetails.title = "Marvel Hero"

        val id = intent.getStringExtra("CHAR_ID")

        val heroDetailsViewModel: HeroDetailsViewModel = ViewModelProviders.of(this).get(HeroDetailsViewModel::class.java)

        heroDetailsViewModel.heroesLiveData.observe(this , Observer {
            heroNameDetails.text = it.name
            heroDescriptionDetails.text = it.description

            val url = "${it.thumbnail.path}/standard_large.${it.thumbnail.extension}"
                .split(":")
            Picasso.get().load("https:" + url[1]).into(heroImageDetails)

        })

        heroDetailsViewModel.getCharById(id.toString())
    }

    //pegando id da herosActivity
    companion object {
        fun getStartIntent(
            context: Context,  charId : String
        ): Intent {
            return Intent(context, HeroDetailsActivity::class.java).apply {
                putExtra("CHAR_ID" , charId)
            }
        }
    }
}