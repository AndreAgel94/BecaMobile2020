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
import com.example.becamobile2020.presentation.viewModel.HeroesViewModel
import com.miguelcatalan.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.activity_heroes.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesActivity : AppCompatActivity() {

//    private val viewModel by lazy {
//        val reposioryAPI = HerosReposioryAPI(AppDataBase.getDatabase(this).heroDao())
//        val factory = HeroesViewModelFactory(reposioryAPI)
//        ViewModelProviders.of(this,factory).get(HeroesViewModel::class.java)
//    }

    private val viewModel : HeroesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)
        toolbarMain.title = getString(R.string.heroes_title)
        setSupportActionBar(toolbarMain)
        viewModel.fecthHeroes()

        viewModel.getAllHeroesDAO().observe(this, Observer {
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

    }

    override fun onCreateOptionsMenu(menu: Menu) : Boolean{

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        val item : MenuItem = menu.findItem(R.id.menu_search)

        searchView.setMenuItem(item)
        val heroesViewModel: HeroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)

        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                heroesViewModel.getHeroesByName(query)
                return false

            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

        })

        return true
    }

}