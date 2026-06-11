package com.example.profileapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DashboardActivity : AppCompatActivity() {

    private lateinit var tvWelcome: TextView
    private lateinit var tvName: TextView
    private lateinit var tvUsername: TextView
    private lateinit var tvBirthPlace: TextView
    private lateinit var tvBirthDate: TextView
    private lateinit var tvHobbies: TextView
    private lateinit var tvBio: TextView
    private lateinit var ivProfile: ImageView

    private var currentImageUri: String? = null

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            data?.let {
                val nama = it.getStringExtra("nama") ?: ""
                val username = it.getStringExtra("username") ?: ""
                val tempat = it.getStringExtra("tempat") ?: ""
                val tanggal = it.getStringExtra("tanggal") ?: ""
                val hobi = it.getStringExtra("hobi") ?: ""
                val bio = it.getStringExtra("bio") ?: ""
                currentImageUri = it.getStringExtra("image")

                tvWelcome.text = "Welcome, $nama!"
                tvName.text = nama
                tvUsername.text = username
                tvBirthPlace.text = tempat
                tvBirthDate.text = tanggal
                tvHobbies.text = hobi
                tvBio.text = bio
                
                if (currentImageUri != null) {
                    ivProfile.setImageURI(Uri.parse(currentImageUri))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Dashboard"

        tvWelcome = findViewById(R.id.tvWelcome)
        tvName = findViewById(R.id.tvName)
        tvUsername = findViewById(R.id.tvUsername)
        tvBirthPlace = findViewById(R.id.tvBirthPlace)
        tvBirthDate = findViewById(R.id.tvBirthDate)
        tvHobbies = findViewById(R.id.tvHobbies)
        tvBio = findViewById(R.id.tvBio)
        ivProfile = findViewById(R.id.ivProfile)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update_profile -> {
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("nama", tvName.text.toString())
                    putExtra("username", tvUsername.text.toString())
                    putExtra("tempat", tvBirthPlace.text.toString())
                    putExtra("tanggal", tvBirthDate.text.toString())
                    putExtra("hobi", tvHobbies.text.toString())
                    putExtra("bio", tvBio.text.toString())
                    putExtra("image", currentImageUri)
                }
                startForResult.launch(intent)
                true
            }
            R.id.action_logout -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}