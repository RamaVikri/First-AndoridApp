package com.example.proyek_app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_film)

        @Suppress("DEPRECATION")
        val film = intent.getParcelableExtra<Film>("FILM")
        if (film != null) {
            findViewById<TextView>(R.id.tv_item_name).text = film.name
            findViewById<TextView>(R.id.tv_item_description).text ="${film.descrip}"
            findViewById<TextView>(R.id.tv_Sutradara).text= "Produser : ${film.dataSutradara}"
            findViewById<TextView>(R.id.tv_Pemeran).text= "Pemeran : ${film.dataPemeran}"
            findViewById<TextView>(R.id.tv_Durasi).text= "Durasi : ${film.dataDurasi} Menit"
            findViewById<TextView>(R.id.tv_Rilis).text= "Tanggal Rilis : ${film.dataRilis}"
            findViewById<ImageView>(R.id.img_item_photo).setImageResource(film.photo)
        } else {
            Toast.makeText(this, "Data film tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
        }


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