package com.example.cinefast2_23l_0740;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    TextView summaryMovie, summarySeats, summaryTicketTotal,
            summarySnackTotal, summaryFinalTotal;

    Button sendTicketBtn;

    String movieName;
    int seatCount;
    int ticketTotal;
    int snackTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        receiveData();
        initializeViews();
        displaySummary();
        setupSendButton();
    }

    private void receiveData() {
        movieName = getIntent().getStringExtra("movie_name");
        seatCount = getIntent().getIntExtra("seat_count", 0);
        ticketTotal = getIntent().getIntExtra("ticket_total", 0);
        snackTotal = getIntent().getIntExtra("snack_total", 0);
    }

    private void initializeViews() {
        summaryMovie = findViewById(R.id.summaryMovie);
        summarySeats = findViewById(R.id.summarySeats);
        summaryTicketTotal = findViewById(R.id.summaryTicketTotal);
        summarySnackTotal = findViewById(R.id.summarySnackTotal);
        summaryFinalTotal = findViewById(R.id.summaryFinalTotal);
        sendTicketBtn = findViewById(R.id.sendTicketBtn);
    }

    private void displaySummary() {
        int finalTotal = ticketTotal + snackTotal;

        summaryMovie.setText(movieName);
        summarySeats.setText("Seats Booked: " + seatCount);
        summaryTicketTotal.setText("Ticket Total: Rs " + ticketTotal);
        summarySnackTotal.setText("Snacks Total: Rs " + snackTotal);
        summaryFinalTotal.setText("TOTAL: Rs " + finalTotal);
    }

    private void setupSendButton() {

        sendTicketBtn.setOnClickListener(v -> {

            int finalTotal = ticketTotal + snackTotal;

            String message =
                    "🎬 CineFAST Ticket\n\n" +
                            "Movie: " + movieName + "\n" +
                            "Seats: " + seatCount + "\n" +
                            "Ticket Total: Rs " + ticketTotal + "\n" +
                            "Snacks Total: Rs " + snackTotal + "\n" +
                            "Final Total: Rs " + finalTotal + "\n\n" +
                            "Enjoy your movie! 🍿";

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, message);

            startActivity(Intent.createChooser(intent, "Share Ticket Via"));
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SummaryActivity.this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
