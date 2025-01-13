package com.example.proyek_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFilms : RecyclerView
    private val list = ArrayList<Film>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFilms = findViewById(R.id.rv_films)
        rvFilms.setHasFixedSize(true)

        list.addAll(getListFilm())
        showRecylerList()

    }

    @SuppressLint("Recycle")
    private fun getListFilm(): ArrayList<Film> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescrip = resources.getStringArray(R.array.data_descrip)
        val sutradara = resources.getStringArray(R.array.detail_sutradara)
        val pemeran = resources.getStringArray(R.array.detail_pemeran)
        val durasi = resources.getStringArray(R.array.detail_durasi)
        val rilis = resources.getStringArray(R.array.detail_tglRilis)
        val dataPoster = resources.obtainTypedArray(R.array.data_poster)
        val listFilm = ArrayList<Film>()
        for(i in dataName.indices){
            val film = Film(dataName[i], dataDescrip[i], sutradara[i], pemeran[i], durasi[i], rilis[i],dataPoster.getResourceId(i, -1))
            listFilm.add(film)
        }
        return listFilm
    }
    private fun showRecylerList(){
        rvFilms.layoutManager = LinearLayoutManager(this)
        val listFilmAdapter = ListFilmAdapter(list)
        rvFilms.adapter = listFilmAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menu_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            true
            }
        else -> super.onOptionsItemSelected(item)
        }
    }

}