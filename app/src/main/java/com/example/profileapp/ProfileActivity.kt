package com.example.profileapp

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.profileapp.R

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val imgResult = findViewById<ImageView>(R.id.imgResult)
        val tvInfo = findViewById<TextView>(R.id.tvInfo)

        val nama = intent.getStringExtra("nama")
        val tempat = intent.getStringExtra("tempat")
        val tanggal = intent.getStringExtra("tanggal")
        val gender = intent.getStringExtra("gender")
        val jurusan = intent.getStringExtra("jurusan")
        val status = intent.getBooleanExtra("status", false)

        val imageUri = intent.getStringExtra("image")

        if (imageUri != null) {
            imgResult.setImageURI(Uri.parse(imageUri))
        }

        tvInfo.text = """
Nama : $nama

Tempat Lahir : $tempat

Tanggal Lahir : $tanggal

Gender : $gender

Jurusan : $jurusan

Status : ${if (status) "Mahasiswa Aktif" else "Tidak Aktif"}
        """.trimIndent()
    }
}