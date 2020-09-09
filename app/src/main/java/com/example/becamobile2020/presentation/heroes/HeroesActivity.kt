package com.example.becamobile2020.presentation.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.becamobile2020.R
import kotlinx.android.synthetic.main.activity_heroes.*

class HeroesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        toolbarMain.title = "Marvel Heroes xD"
        setSupportActionBar(toolbarMain)
    }
}