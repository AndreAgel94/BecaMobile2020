package com.example.becamobile2020.presentation.acivitys

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.becamobile2020.R
import com.example.becamobile2020.presentation.viewModel.HeroDetailsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hero_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HeroDetailsActivity : AppCompatActivity() {

//    private val viewModel by lazy {
//        val reposiory = HerosReposioryAPI(AppDataBase.getDatabase(this).heroDao())
//        val factory = HeroDetailsViewModelFactory(reposiory)
//        ViewModelProviders.of(this,factory).get(HeroDetailsViewModel::class.java)
//    }

    private val viewModel : HeroDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_details)
        toolbarDetails.title = "Marvel Hero"
        val id = intent.getStringExtra("CHAR_ID")

//        viewModel.getCharById(id.toString()).observe(this, Observer {
//            heroNameDetails.text = it.name
//            heroDescriptionDetails.text = it.description
//
//            val url = "${it.thumbnail.path}/standard_large.${it.thumbnail.extension}"
//                .split(":")
//            Picasso.get().load("https:" + url[1]).into(heroImageDetails)
//        })
        viewModel.getCharByIdDAO(id.toString()).observe(this, Observer {
            heroNameDetails.text = it.name
            heroDescriptionDetails.text = it.description

            val url = "${it.path}/standard_large.${it.extension}"
                .split(":")
                Picasso.get().load("https:" + url[1]).into(heroImageDetails)
        })
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