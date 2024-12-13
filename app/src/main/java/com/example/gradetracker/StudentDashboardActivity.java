/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file StudentDashboardActivity.java
 */

package com.example.gradetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gradetracker.database.entities.GradeTrackerRepository;
import com.example.gradetracker.databinding.ActivityStudentDashboardBinding;

public class StudentDashboardActivity extends AppCompatActivity {

    private ActivityStudentDashboardBinding binding;
    private GradeTrackerRepository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.gradetracker.databinding.ActivityStudentDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        repository = GradeTrackerRepository.getRepository(getApplication());
        binding.viewGradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewGradesActivity.viewGradesIntentFactory(getApplicationContext()));
            }
        });
        binding.trackAssignmentStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(TrackAssignmentActivity.trackAssignmentIntentFactory(getApplicationContext()));
            }
        });
    }

    static Intent studentDashboardIntentFactory(Context context) {
        return new Intent(context, StudentDashboardActivity.class);
    }
}
