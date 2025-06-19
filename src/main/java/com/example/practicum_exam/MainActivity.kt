package com.example.practicum_exam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Parallel arrays
    private val songTitles = arrayOfNulls<String>(4)
    private val artistNames = arrayOfNulls<String>(4)
    private val songRatings = IntArray(4)
    private val songComments = arrayOfNulls<String>(4)
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        val addButton = findViewById<Button>(R.id.addButton)
        val viewButton = findViewById<Button>(R.id.viewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val titleInput = findViewById<EditText>(R.id.titleInput)
        val artistInput = findViewById<EditText>(R.id.artistInput)
        val ratingInput = findViewById<EditText>(R.id.ratingInput)
        val commentInput = findViewById<EditText>(R.id.commentInput)

        addButton.setOnClickListener {
            try {
                val title = titleInput.text.toString().trim()
                val artist = artistInput.text.toString().trim()
                val rating = ratingInput.text.toString().toInt()
                val comment = commentInput.text.toString().trim()

                // Input validation
                when {
                    title.isEmpty() -> {
                        titleInput.error = "Please enter song title"
                        return@setOnClickListener
                    }
                    artist.isEmpty() -> {
                        artistInput.error = "Please enter artist name"
                        return@setOnClickListener
                    }
                    rating !in 1..5 -> {
                        ratingInput.error = "Rating must be 1-5"
                        return@setOnClickListener
                    }
                    comment.isEmpty() -> {
                        commentInput.error = "Please enter comments"
                        return@setOnClickListener
                    }
                    currentIndex >= 4 -> {
                        Toast.makeText(this, "Playlist full (max 4 songs)", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }

                // Add song to arrays
                songTitles[currentIndex] = title
                artistNames[currentIndex] = artist
                songRatings[currentIndex] = rating
                songComments[currentIndex] = comment
                currentIndex++

                // Clear input fields
                titleInput.text.clear()
                artistInput.text.clear()
                ratingInput.text.clear()
                commentInput.text.clear()

                Toast.makeText(this, "Song added to playlist!", Toast.LENGTH_SHORT).show()

            } catch (e: NumberFormatException) {
                ratingInput.error = "Please enter a valid number"
            } catch (e: Exception) {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        viewButton.setOnClickListener {
            if (currentIndex == 0) {
                Toast.makeText(this, "Playlist is empty", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("titles", songTitles)
                    putExtra("artists", artistNames)
                    putExtra("ratings", songRatings)
                    putExtra("comments", songComments)
                }
                startActivity(intent)
            }
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}