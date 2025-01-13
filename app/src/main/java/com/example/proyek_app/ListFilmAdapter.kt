package com.example.proyek_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class ListFilmAdapter(private val listFilm : ArrayList<Film>) : RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_film, parent, false)
        return ListViewHolder(view)
   }


    override fun getItemCount(): Int = listFilm.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, descrip, dataSutradara, dataPemeran, dataDurasi, dataRilis, photo) = listFilm[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = descrip

//        holder.itemView.setOnClickListener(
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listFilm[holder.adapterPosition].name, Toast.LENGTH_SHORT ).show()
//        )

        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("FILM", Film(name,descrip, dataSutradara, dataPemeran, dataDurasi, dataRilis, photo ))
            holder.itemView.context.startActivity(intent)

        }

    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)


    }
}


