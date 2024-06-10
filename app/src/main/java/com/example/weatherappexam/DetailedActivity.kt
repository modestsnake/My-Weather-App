package com.example.weatherappexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val view = findViewById<TextView>(R.id.view)
        val red = findViewById<TextView>(R.id.red)
        val maroon = findViewById<TextView>(R.id.maroon)

        val intent = intent
        val temperatures = intent.getSerializableExtra("temperatures") as? Map<String, Pair<Int, Int>>
        val days = intent.getStringArrayListExtra("days")
        val weatherConditions = intent.getStringArrayListExtra("conditions")
        val averageTemperature = intent.getIntExtra("averageTemperature", 0)

        if (temperatures != null && days != null && weatherConditions != null) {
            for (day in days) {
                val weatherData = temperatures[day]

                view.append("Day: $day\n")
                view.append("Min Temp: ${weatherData?.first}\n") // Display minimum temperature on view
                red.append("Max Temp: ${weatherData?.second}\n")
                red.append("Weather Condition: ${weatherConditions.random()}\n")
                red.append("\n")
            }
            maroon.text = "Average Temperature: $averageTemperature"
        } else {
        }
    }
}
