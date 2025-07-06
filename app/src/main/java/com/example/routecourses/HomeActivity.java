package com.example.routecourses;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "HomeActivity"; // Define a TAG for logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button androidCourseButton = findViewById(R.id.AndroidCourseButton);
        Button iosCourseButton = findViewById(R.id.IOSCourseButton);
        Button fullStackCourseButton = findViewById(R.id.FullStackCourseButton);

        // Set the same OnClickListener for all buttons
        androidCourseButton.setOnClickListener(this);
        iosCourseButton.setOnClickListener(this);
        fullStackCourseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String courseName = "";
        // Determine which button was clicked
        // Using if/else if with getId()
        if (v.getId() == R.id.AndroidCourseButton) {
            courseName = "Android";
            Log.d(TAG, "onClick: Android Course Button Clicked");
        } else if (v.getId() == R.id.IOSCourseButton) {
            courseName = "IOS";
            Log.d(TAG, "onClick: IOS Course Button Clicked");
        } else if (v.getId() == R.id.FullStackCourseButton) {
            courseName = "Full Stack";
            Log.d(TAG, "onClick: Full Stack Course Button Clicked");
        }

        // Start the CoursesContentActivity if a courseName was set
        if (!courseName.isEmpty()) {
            Intent intent = new Intent(HomeActivity.this, CoursesContentActivity.class);
            intent.putExtra("courseName", courseName);
            startActivity(intent);
        }
    }
}
