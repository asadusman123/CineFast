package com.example.cinefast2_23l_0740;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeatActivity extends AppCompatActivity {

    TextView movieTitle, seatCountText, totalPriceText;
    Button proceedBtn, bookNowBtn;

    Button[] seats = new Button[12];

    int selectedSeats = 0;
    int ticketPrice = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        initializeViews();
        getMovieName();
        setupSeatLogic();
        setupButtons();
    }

    private void initializeViews() {

        movieTitle = findViewById(R.id.movieTitle);
        seatCountText = findViewById(R.id.seatCountText);
        totalPriceText = findViewById(R.id.totalPriceText);

        proceedBtn = findViewById(R.id.proceedBtn);
        bookNowBtn = findViewById(R.id.bookNowBtn);

        for (int i = 0; i < 12; i++) {
            int resID = getResources().getIdentifier("seat" + (i + 1), "id", getPackageName());
            seats[i] = findViewById(resID);
        }
    }

    private void getMovieName() {
        String movieName = getIntent().getStringExtra("movie_name");
        movieTitle.setText(movieName);
    }

    private void setupSeatLogic() {

        for (Button seat : seats) {

            seat.setOnClickListener(v -> {

                if (seat.isSelected()) {
                    seat.setSelected(false);
                    seat.setBackgroundTintList(
                            android.content.res.ColorStateList.valueOf(Color.parseColor("#444444"))
                    );
                    selectedSeats--;
                } else {
                    seat.setSelected(true);
                    seat.setBackgroundTintList(
                            android.content.res.ColorStateList.valueOf(Color.parseColor("#E50914"))
                    );
                    selectedSeats++;
                }

                updateUI();
            });
        }
    }

    private void updateUI() {

        seatCountText.setText("Selected Seats: " + selectedSeats);

        int totalPrice = selectedSeats * ticketPrice;
        totalPriceText.setText("Total Price: Rs " + totalPrice);

        proceedBtn.setEnabled(selectedSeats > 0);
        bookNowBtn.setEnabled(selectedSeats > 0);
    }

    private void setupButtons() {

        proceedBtn.setOnClickListener(v -> {

            Intent intent = new Intent(SeatActivity.this, SnacksActivity.class);
            intent.putExtra("movie_name", movieTitle.getText().toString());
            intent.putExtra("seat_count", selectedSeats);
            intent.putExtra("ticket_total", selectedSeats * ticketPrice);

            startActivity(intent);
            finish(); // IMPORTANT
        });

        bookNowBtn.setOnClickListener(v -> {

            Intent intent = new Intent(SeatActivity.this, SummaryActivity.class);
            intent.putExtra("movie_name", movieTitle.getText().toString());
            intent.putExtra("seat_count", selectedSeats);
            intent.putExtra("ticket_total", selectedSeats * ticketPrice);
            intent.putExtra("snack_total", 0);

            startActivity(intent);
            finish(); // IMPORTANT
        });
    }
}
