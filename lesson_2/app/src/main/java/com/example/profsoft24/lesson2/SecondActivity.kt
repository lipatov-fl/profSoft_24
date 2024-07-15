package com.example.profsoft24.lesson2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.profsoft24.databinding.ActivitySecondBinding
import com.example.profsoft24.lesson2.сonstants.Constants

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.secondActivityBtn.setOnClickListener {
            val message = intent.getStringExtra(Constants.STRING_EXTRA_KEY)
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}