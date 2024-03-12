package com.sugam.trail12.Activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sugam.trail12.Adapter.Adapter
import com.sugam.trail12.R
import com.sugam.trail12.databinding.ActivityMainBinding
import com.sugam.trail12.dataclass.User
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var arrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor=Color.TRANSPARENT
        title="MAin"
        val sharedPreferences=getSharedPreferences(getString(R.string.credentials), Context.MODE_PRIVATE)
        getjsondata()

        binding.listView.isClickable = true
        binding.listView.adapter = Adapter(this, arrayList)
        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
//            sharedPreferences.edit().clear().apply()
//            sharedPreferences.edit().putInt("image", arrayList[i].imageId).apply()
//            sharedPreferences.edit().putString("name", arrayList[i].name).apply()
//            sharedPreferences.edit().putString("description", arrayList[i].description).apply()
//            sharedPreferences.edit().putString("time", arrayList[i].time).apply()

            val intent = Intent(this, Display::class.java)
            intent.putExtra("image", arrayList[i].imageId)
            intent.putExtra("name", arrayList[i].name)
            intent.putExtra("description", arrayList[i].description)
            intent.putExtra("time", arrayList[i].time)

            startActivity(intent)
        }


    }

    private fun getjsondata() {
        arrayList = arrayListOf<User>()
        try {
            val inputStream = assets.open("data.json")
            val jsontext = inputStream.bufferedReader().use { it.readText() }
            val jsonObject = JSONObject(jsontext)
            val jsonArray = jsonObject.getJSONArray("items")

            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val image = getresouceid(obj.getString("imageId"))
                val name = obj.getString("name")
                val message = obj.getString("message")
                val time = obj.getString("time")

                arrayList.add(User(image, name, message, time))
                arrayList.add(User(image, name, message, time))
                arrayList.add(User(image, name, message, time))
                arrayList.add(User(image, name, message, time))
                arrayList.add(User(image, name, message, time))
            }


        } catch (e: Exception) {
            Log.i("ex250","error occured ${e.message}")
        }


    }

    private fun getresouceid(string: String): Int {
        val source = string.substringAfterLast(".")
        return resources.getIdentifier(source, "drawable", packageName)
    }


}
