package com.example.ittalian.outofbusinesscards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.example.ittalian.outofbusinesscards.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

            binding.companyEdit.setText(company)
            binding.postalEdit.setText(postal)
            binding.addressEdit.setText(address)
            binding.telEdit.setText(tel)
            binding.faxEdit.setText(fax)
            binding.emailEdit.setText(email)
            binding.urlEdit.setText(url)
            binding.positionEdit.setText(position)
            binding.nameEdit.setText(name)
        }

        binding.saveBtn.setOnClickListener {
            saveData()
            finish()
        }

        binding.cancelBtn.setOnClickListener {
            finish()
        }
    }

    private fun saveData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putString("company", binding.companyEdit.text.toString())
            .putString("postal", binding.postalEdit.text.toString())
            .putString("address", binding.addressEdit.text.toString())
            .putString("tel", binding.telEdit.text.toString())
            .putString("fax", binding.faxEdit.text.toString())
            .putString("email", binding.emailEdit.text.toString())
            .putString("url", binding.urlEdit.text.toString())
            .putString("position", binding.positionEdit.text.toString())
            .putString("name", binding.nameEdit.text.toString())
            .apply()
    }
}