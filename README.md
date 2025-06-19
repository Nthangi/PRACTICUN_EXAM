# PRACTICUN_EXAM
Music Playlist Manager – README 

Student Information 

Name: [Nthangene] 

Student Number: [10492130] 

 

📱 Application Overview 

A Kotlin Android app for managing music playlists with features to: 

Add songs with ratings (1-5 stars) 

View playlist details 

Calculate average song ratings 

Navigate between screens 

🛠 Technical Implementation 

Core Features 

Parallel arrays for storing song data (titles, artists, ratings, comments) 

Input validation for all fields 

Screen navigation between main and detail views 

Average rating calculation using loops 

 

Code Structure 

/app 
├── src/main 
│   ├── java/com/example/practicum_exam 
│   │   ├── MainActivity.kt 
│   │   └── DetailActivity.kt 
│   ├── res/layout 
│   │   ├── activity_main.xml 
│   │   └── activity_detail.xml 
│   └── AndroidManifest.xml 
  

📋 Requirements Checklist 

Main Screen (Q.1.2) 

"Add to Playlist" button with input fields: 

Song title 

Artist name 

Rating (1-5) 

User comments 

"View Playlist" button (navigates to detail screen) 

"Exit App" button 

Detail View (Q.1.3) 

Button to display song list with details 

Button to calculate average rating 

Back button to return to main screen 

🚀 Installation 

Clone the repository:git clone https://github.com/yourusername/practicum_exam.git 
  

Open in Android Studio 

Build and run on emulator/device 

 

 

 

📸 Screenshots 

Main Screen 

Picture 

 

 

 

 

 

 

 

 

 

 

 

 

 

Detail View 

Entre your details  

Picture 

You are allowed to enter only 4 options of songs  

After every song you click the “Add to playlist” button 

After you have entered your 4 songs you can then click the “View playlist” button and it will take you to the screen  

 

 

 

PictureView screen  

 

Picture 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

This is the second screen where you can view your playlist and see the average rate calculated  

You click the “show song playlist” button and the list of songs will be displayed  

You click the “calculate average rating” button to display the average rating  

 

Error handling 

 

Picture 

When you are missing any input, it will let you know with a red tag on that text view “Please entre a valid number “, and it tells you exactly what you need to do like in this case the user didn't enter the rating number  

Picture 

 

  

 

when the user doesn't enter anything, it will display that playlist is empty 

Picture 

When you try to enter more the 4 songs it will restrict you by saying “playlist full” 

 

📝 Code Highlights 

MainActivity.kt 

// Parallel arrays for song data 
private val songTitles = arrayOfNulls<String>(4) 
private val artistNames = arrayOfNulls<String>(4) 
private val songRatings = IntArray(4) 
private val songComments = arrayOfNulls<String>(4) 
 
// Input validation example 
if (rating !in 1..5) { 
    ratingInput.error = "Rating must be 1-5" 
    return@setOnClickListener 
} 
  

DetailActivity.kt 

// Calculate average rating 
val average = ratings.average() 
avgRatingText.text = "Average Rating: ${"%.1f".format(average)}/5" 
  

✅ Grading Criteria Met 

Correct array/loop implementation 

Accurate average rating calculation 

Proper screen navigation 

Clean UI design 

Comprehensive error handling 

Well-documented code 

📧 Contact 

For issues or questions, please contact: [ST10492130] 

 

 

 

 LINK TO GITHUB 

 
