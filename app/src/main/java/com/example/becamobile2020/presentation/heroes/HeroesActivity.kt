package com.example.becamobile2020.presentation.heroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.becamobile2020.R
import com.example.becamobile2020.data.model.Hero
import com.example.becamobile2020.presentation.details.HeroDetailsActivity
import com.miguelcatalan.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.activity_heroes.*

class HeroesActivity : AppCompatActivity() {

//     val heroesViewModel: HeroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
//       lateinit var charactersVMFactory: ViewModelFactory<HeroesViewModel>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        toolbarMain.title = getString(R.string.heroes_title)
        setSupportActionBar(toolbarMain)

        val heroesViewModel: HeroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)


        heroesViewModel.heroesLiveData.observe(this, Observer {
            it?.let {
                with(recyclerHeroes) {
                    layoutManager =
                        LinearLayoutManager(this@HeroesActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = HeroesAdapter(it) {

                        val intent = HeroDetailsActivity.getStartIntent(
                            this@HeroesActivity, it.name,
                            it.description, it.thumbnail.path, it.thumbnail.extension
                        )

                        this@HeroesActivity.startActivity(intent)

                    }
                }
            }
        })

        heroesViewModel.getHeroes()
    }

    override fun onCreateOptionsMenu(menu: Menu) : Boolean{

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        val item : MenuItem = menu.findItem(R.id.menu_search)
        searchView.setMenuItem(item)
        var  heroesViewModel: HeroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)

        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                Log.i("query" , query)
                heroesViewModel.getHeroesSelected(query)
                return false

            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

        })

        return true
    }

//    fun filterHero(hero :String) {
//        var  heroesViewModel: HeroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
//
//        heroesViewModel.filterHero(hero)
//    }

}