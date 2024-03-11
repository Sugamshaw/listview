package com.sugam.trail12.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sugam.trail12.R
import com.sugam.trail12.databinding.ActivityDisplayBinding

class Display : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setImageResource(intent.getIntExtra("image", R.drawable.a1))
        binding.name.setText(intent.getStringExtra("name").toString())
        binding.name.setText(intent.getStringExtra("description"))
        binding.name.setText(intent.getStringExtra("time"))

    }
}