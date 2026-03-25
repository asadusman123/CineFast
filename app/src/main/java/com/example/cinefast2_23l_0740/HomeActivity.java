package com.example.cinefast2_23l_0740;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button bookDarkKnight, trailerDarkKnight;
    Button bookInception, trailerInception;
    Button bookInterstellar, trailerInterstellar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeViews();
        setupListeners();
    }

    private void initializeViews() {
        bookDarkKnight = findViewById(R.id.bookDarkKnight);
        trailerDarkKnight = findViewById(R.id.trailerDarkKnight);

        bookInception = findViewById(R.id.bookInception);
        trailerInception = findViewById(R.id.trailerInception);

        bookInterstellar = findViewById(R.id.bookInterstellar);
        trailerInterstellar = findViewById(R.id.trailerInterstellar);


    }

    private void setupListeners() {


        bookDarkKnight.setOnClickListener(v ->
                openSeatScreen("The Dark Knight"));

        trailerDarkKnight.setOnClickListener(v ->
                openTrailer("https://www.youtube.com/watch?v=EXeTwQWrcwY"));


        bookInception.setOnClickListener(v ->
                openSeatScreen("Inception"));

        trailerInception.setOnClickListener(v ->
                openTrailer("https://www.youtube.com/watch?v=YoHD9XEInc0"));


        bookInterstellar.setOnClickListener(v ->
                openSeatScreen("Interstellar"));

        trailerInterstellar.setOnClickListener(v ->
                openTrailer("https://www.youtube.com/watch?v=zSWdZVtXT7E"));




    }

    private void openSeatScreen(String movieName) {
        Intent intent = new Intent(HomeActivity.this, SeatActivity.class);
        intent.putExtra("movie_name", movieName);
        startActivity(intent);
    }

    private void openTrailer(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
