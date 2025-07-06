package com.example.routecourses;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity; // Consistent import order
import androidx.viewpager2.widget.ViewPager2;

public class CoursesContentActivity extends AppCompatActivity {

    // Define constants for your intent extras. This avoids typos and makes refactoring easier.
    public static final String EXTRA_COURSE_NAME = "courseName";

    // Define constants for course names to avoid magic strings
    private static final String COURSE_ANDROID = "Android";
    private static final String COURSE_IOS = "IOS";
    private static final String COURSE_FULL_STACK = "Full Stack";

    // TAG for logging
    private static final String TAG = "CoursesContentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_content);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setUserInputEnabled(false); // Disables all user-initiated swiping

        Intent intent = getIntent();

        // Check if intent and extras are not null first
        if (intent != null && intent.getExtras() != null) {
            // Use the constant for the extra key
            String courseName = intent.getStringExtra(EXTRA_COURSE_NAME);

            if (courseName != null) { // Null check for courseName once
                // Use a switch statement for cleaner conditional logic with strings (Java 7+)
                // Or continue with if-else if if preferred/older Java version
                switch (courseName) {
                    case COURSE_ANDROID:
                        Log.d(TAG, "onCreate: Android Screen Opened for course: " + courseName);
                        viewPager.setCurrentItem(0);
                        break;
                    case COURSE_IOS:
                        Log.d(TAG, "onCreate: IOS Screen Opened for course: " + courseName);
                        viewPager.setCurrentItem(1);
                        break;
                    case COURSE_FULL_STACK:
                        Log.d(TAG, "onCreate: FullStack Screen Opened for course: " + courseName);
                        viewPager.setCurrentItem(2);
                        break;
                    default:
                        // Optional: Handle unknown course name, maybe default to the first page or log a warning
                        Log.w(TAG, "onCreate: Unknown course name received: " + courseName + ". Defaulting to first page.");
                        viewPager.setCurrentItem(0); // Example: default to the first item
                        break;
                }
            } else {
                // Optional: Handle case where courseName extra is missing, though your previous check for getExtras() also covers this
                Log.w(TAG, "onCreate: courseName extra was null. Defaulting to first page.");
                viewPager.setCurrentItem(0); // Example: default to the first item
            }
        } else {
            // Optional: Handle case where intent or extras are null
            Log.w(TAG, "onCreate: Intent or extras were null. Defaulting to first page.");
            viewPager.setCurrentItem(0); // Example: default to the first item
        }
    }
}
