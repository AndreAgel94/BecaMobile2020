package com.example.becamobile2020.presentation.acivitys


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.becamobile2020.R
import com.example.becamobile2020.data.repository.HerosReposiory
import com.example.becamobile2020.presentation.factory.HeroesViewModelFactory
import com.example.becamobile2020.presentation.viewModel.HeroesViewModel
import com.miguelcatalan.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.activity_heroes.*

class HeroesActivity : AppCompatActivity() {

    private val viewModel by lazy {
        val reposiory = HerosReposiory()
        val factory = HeroesViewModelFactory(reposiory)
        ViewModelProviders.of(this,factory).get(HeroesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)
        toolbarMain.title = getString(R.string.heroes_title)
        setSupportActionBar(toolbarMain)

        viewModel.getHeroes().observe(this, Observer {
            it?.let {
                with(recyclerHeroes){
                    layoutManager = LinearLayoutManager(
                        this@HeroesActivity,
                        RecyclerView.VERTICAL,
                        false)
                    setHasFixedSize(true)

                    adapter = HeroesAdapter(it){
                        val intent = HeroDetailsActivity.getStartIntent(
                            this@HeroesActivity,
                            it.id
                        )

                        this@HeroesActivity.startActivity(intent)

                    }
                }
            }
        })

//        val heroesViewModel: HeroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
//
//        //Observa o livedata do VM
//        heroesViewModel.heroesLiveData.observe(this, Observer {
//            it?.let {
//                with(recyclerHeroes) {
//                    layoutManager =
//                        LinearLayoutManager(this@HeroesActivity, RecyclerView.VERTICAL, false)
//                        setHasFixedSize(true)
//                    //Seta ao adapter uma lista de character
//
//                    adapter = HeroesAdapter(it) {
//                        //recebendo no lambda um character
//                        // e passando o character para a getIntent da details.
//                        val intent = HeroDetailsActivity.getStartIntent(
//
//                            this@HeroesActivity, it.id
//                        )
//
//                        this@HeroesActivity.startActivity(intent)
//
//                    }
//                }
//            }
//        })

       // heroesViewModel.getHeroes()
    }

    override fun onCreateOptionsMenu(menu: Menu) : Boolean{

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        val item : MenuItem = menu.findItem(R.id.menu_search)

        searchView.setMenuItem(item)
        val heroesViewModel: HeroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)

        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                heroesViewModel.getHeroesSelected(query)
                return false

            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

        })

        return true
    }

}