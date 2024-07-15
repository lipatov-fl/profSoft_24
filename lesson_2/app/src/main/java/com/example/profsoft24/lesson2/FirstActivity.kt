package com.example.profsoft24.lesson2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.profsoft24.databinding.ActivityFirstBinding
import com.example.profsoft24.lesson2.сonstants.Constants

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstActivityBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(Constants.STRING_EXTRA_KEY, binding.greetingsText.text.toString())
            }
            startActivity(intent)
        }
    }
}