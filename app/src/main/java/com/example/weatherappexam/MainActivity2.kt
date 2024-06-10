package com.example.weatherappexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.content.Intent
import java.io.Serializable
import kotlin.random.Random
import android.widget.Toast


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val talk = findViewById<ImageView>(R.id.talk)
        val end2 = findViewById<Button>(R.id.end2)
        val finish = findViewById<Button>(R.id.finish)
        val clear = findViewById<ImageView>(R.id.clear)
        val cleared = findViewById<ImageView>(R.id.cleared)

        val days =
            listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val weatherConditions = listOf("Sunny", "Cloudy", "Raining")

        val temperatures = mutableMapOf<String, Pair<Int, Int>>()
        for (day in days) {
            val minTemperature = Random.nextInt(10, 21)
            val maxTemperature = Random.nextInt(22, 31)
            temperatures[day] = Pair(minTemperature, maxTemperature)
        }

        end2.setOnClickListener {
            val intent = Intent(this@MainActivity2, DetailedActivity::class.java)
            Toast.makeText(this@MainActivity2, "Enter a weekday", Toast.LENGTH_SHORT).show()

            intent.putExtra("temperatures", temperatures as Serializable)
            intent.putStringArrayListExtra("days", ArrayList(days))
            intent.putStringArrayListExtra("conditions", ArrayList(weatherConditions))

            val totalTemperature = temperatures.values.sumBy { it.first + it.second }
            val averageTemperature = totalTemperature / (temperatures.size * 2)
            intent.putExtra("averageTemperature", averageTemperature)

            startActivity(intent)
        }

        finish.setOnClickListener {
            clearData()
        }
    }

    private fun clearData() {
    }
}
