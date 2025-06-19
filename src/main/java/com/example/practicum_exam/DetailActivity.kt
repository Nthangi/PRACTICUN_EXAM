package com.example.practicum_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


            val songListText = findViewById<TextView>(R.id.songList)
            val avgRatingText = findViewById<TextView>(R.id.avgRating)
            val backButton = findViewById<Button>(R.id.backButton)
            val showListButton=findViewById<Button>(R.id.showListButton)
            val calcAvgButton=findViewById<Button>(R.id.calcAvgButton)

        val titles = intent.getStringArrayExtra("titles") ?: arrayOf()
        val artists = intent.getStringArrayExtra("artists") ?: arrayOf()
        val ratings = intent.getIntArrayExtra("ratings") ?: intArrayOf()
        val comments = intent.getStringArrayExtra("comments") ?: arrayOf()

            backButton.setOnClickListener {
                finish()
            }

        showListButton.setOnClickListener {
            try {
                if (titles.isEmpty()) {
                    Toast.makeText(this, "No songs in playlist", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val stringBuilder = StringBuilder("Playlist Songs:\n\n")
                val itemCount = minOf(titles.size, artists.size, ratings.size, comments.size)

                for (i in 0 until itemCount) {
                    stringBuilder.append("""
                    Song ${i + 1}:
                    Title: ${titles[i]}
                    Artist: ${artists.getOrElse(i) { "Unknown" }}
                    Rating: ${ratings.getOrElse(i) { 0 }}/5
                    Comment: ${comments.getOrElse(i) { "No comments" }}
                    
                    """.trimIndent())
                }
                songListText.text = stringBuilder.toString()
            } catch (e: Exception) {
                Toast.makeText(this, "Error displaying songs: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        calcAvgButton.setOnClickListener {
            try {
                if (ratings.isEmpty()) {
                    Toast.makeText(this, "No valid ratings available", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val average = ratings.average()
                avgRatingText.text = "Average Rating: ${"%.1f".format(average)}/5"
            } catch (e: Exception) {
                Toast.makeText(this, "Error calculating average: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}