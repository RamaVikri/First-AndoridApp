package com.example.proyek_app

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val name: String,
    val descrip : String,
    val dataSutradara : String,
    val dataPemeran : String,
    val dataDurasi : String,
    val dataRilis : String,
    val photo : Int
) : Parcelable
