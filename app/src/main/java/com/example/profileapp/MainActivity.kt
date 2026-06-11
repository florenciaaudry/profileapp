package com.example.profileapp

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var imgProfile: ImageView
    private lateinit var etNama: EditText
    private lateinit var etUsername: EditText
    private lateinit var etTempat: EditText
    private lateinit var etTanggal: EditText
    private lateinit var etHobbies: EditText
    private lateinit var etBio: EditText

    private var imageUri: Uri? = null

    private val imagePicker =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                imageUri = it
                imgProfile.setImageURI(it)
                imgProfile.setBackgroundColor(android.graphics.Color.TRANSPARENT)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgProfile = findViewById(R.id.imgProfile)
        etNama = findViewById(R.id.etNama)
        etUsername = findViewById(R.id.etUsername)
        etTempat = findViewById(R.id.etTempat)
        etTanggal = findViewById(R.id.etTanggal)
        etHobbies = findViewById(R.id.etHobbies)
        etBio = findViewById(R.id.etBio)

        val btnPick = findViewById<Button>(R.id.btnPick)
        val btnSave = findViewById<Button>(R.id.btnSave)

        // Pre-fill if coming from dashboard update
        etNama.setText(intent.getStringExtra("nama") ?: "Florencia Audry")
        etUsername.setText(intent.getStringExtra("username") ?: "florenciaa")
        etTempat.setText(intent.getStringExtra("tempat") ?: "Medan")
        etTanggal.setText(intent.getStringExtra("tanggal") ?: "14 April 2006")
        etHobbies.setText(intent.getStringExtra("hobi") ?: "habisin duit")
        etBio.setText(intent.getStringExtra("bio") ?: "hai aku floren")
        intent.getStringExtra("image")?.let {
            imageUri = Uri.parse(it)
            imgProfile.setImageURI(imageUri)
        }

        btnPick.setOnClickListener {
            val options = arrayOf("Gallery", "Default Profile (Pink)", "Default Profile (Blue)")
            androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Select Image")
                .setItems(options) { _, which ->
                    when (which) {
                        0 -> imagePicker.launch("image/*")
                        1 -> {
                            imageUri = null
                            imgProfile.setImageResource(android.R.drawable.ic_menu_gallery)
                            imgProfile.setBackgroundColor(android.graphics.Color.MAGENTA)
                        }
                        2 -> {
                            imageUri = null
                            imgProfile.setImageResource(android.R.drawable.ic_menu_gallery)
                            imgProfile.setBackgroundColor(android.graphics.Color.CYAN)
                        }
                    }
                }
                .show()
        }

        etTanggal.setOnClickListener {
            showDatePicker()
        }

        btnSave.setOnClickListener {
            saveData()
        }
    }

    private fun showDatePicker() {
        val cal = Calendar.getInstance()
        DatePickerDialog(
            this,
            { _, year, month, day ->
                val dateStr = "$day/${month + 1}/$year"
                etTanggal.setText(dateStr)
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun saveData() {
        val resultIntent = Intent()
        resultIntent.putExtra("nama", etNama.text.toString())
        resultIntent.putExtra("username", etUsername.text.toString())
        resultIntent.putExtra("tempat", etTempat.text.toString())
        resultIntent.putExtra("tanggal", etTanggal.text.toString())
        resultIntent.putExtra("hobi", etHobbies.text.toString())
        resultIntent.putExtra("bio", etBio.text.toString())
        imageUri?.let { resultIntent.putExtra("image", it.toString()) }
        
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}