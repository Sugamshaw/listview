package com.sugam.trail12.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sugam.trail12.R
import com.sugam.trail12.databinding.ActivityDisplayBinding

class Display : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences(
            getString(R.string.credentials), MODE_PRIVATE
        )
//        binding.imageView.setImageResource(sharedPreferences.getInt("image",R.drawable.a1))
//        binding.name.setText(sharedPreferences.getString("name",""))
//        binding.Description.setText(sharedPreferences.getString("description","asddsa"))
//        binding.time.setText(sharedPreferences.getString("time",""))



        binding.imageView.setImageResource(intent.getIntExtra("image", R.drawable.a1))
        binding.name.setText(intent.getStringExtra("name").toString())
        binding.Description.setText(intent.getStringExtra("description"))
        binding.time.setText(intent.getStringExtra("time"))

    }
}