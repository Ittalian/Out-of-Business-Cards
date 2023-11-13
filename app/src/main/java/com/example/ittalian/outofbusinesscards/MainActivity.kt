package com.example.ittalian.outofbusinesscards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
import com.example.ittalian.outofbusinesscards.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        PreferenceManager.getDefaultSharedPreferences(this).apply {
            val company = getString("company", "")
            val postal = getString("postal", "")
            val address= getString("address", "")
            val tel = getString("tel", "")
            val fax = getString("fax", "")
            val email = getString("email", "")
            val url = getString("url", "")
            val position = getString("position", "")
            val name = getString("name", "")

            binding.companyText.text = company
            binding.postalText.text = postal
            binding.addressText.text = address
            binding.telText.text = "tel:" + tel
            binding.faxText.text = "fax:" + fax
            binding.emailText.text = email
            binding.urlText.text = url
            binding.positionText.text = position
            binding.nameText.text = name
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            R.id.edit -> {
                val intent = Intent(this, EditActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}