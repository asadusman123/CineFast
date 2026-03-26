package com.example.cinefast2_23l_0740;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {

    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_onboarding);


        initializeViews();


        setupClickListeners();
    }


    private void initializeViews() {
        startBtn = findViewById(R.id.startBtn);
    }


    private void setupClickListeners() {

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);


                startActivity(intent);


                finish();
            }
        });
    }
}
