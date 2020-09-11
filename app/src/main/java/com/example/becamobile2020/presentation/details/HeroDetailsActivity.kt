package com.example.becamobile2020.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.becamobile2020.R
import com.example.becamobile2020.data.response.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hero_details.*
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_details)

        toolbarDetails.setTitle("Marvel Hero")

        val name = intent.getStringExtra("CHAR_NAME")
        val description = intent.getStringExtra("CHAR_DESCRIPTION")
        val path = intent.getStringExtra("CHAR_IMG_PATH")
        val extension = intent.getStringExtra("CHAR_IMAGE_EXTENSION")

        heroNameDetails.text = name
        //heroDescriptionDetails.text = description
        if (description == null || description == ""){
            heroDescriptionDetails.text = "Marvel biographers have not yet traveled the universe of this hero," +
                    " soon he will be studied."
        }else{
            heroDescriptionDetails.text = description
        }



        var url = "$path/standard_large.${extension}".split(":")
        Picasso.get().load("https:"+url[1]).into(heroImageDetails)
    }

    companion object {
        fun getStartIntent(
            context: Context, charName: String, charDescription: String,
            charImgPath: String, charImgExtension: String
        ): Intent {
            return Intent(context, HeroDetailsActivity::class.java).apply {
                putExtra("CHAR_NAME" , charName)
                putExtra("CHAR_DESCRIPTION" , charDescription)
                putExtra("CHAR_IMG_PATH" , charImgPath)
                putExtra("CHAR_IMAGE_EXTENSION" , charImgExtension)
            }
        }
    }
}