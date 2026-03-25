package com.example.cinefast2_23l_0740;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SnacksActivity extends AppCompatActivity {

    int popcornQty = 0, nachosQty = 0, drinkQty = 0, candyQty = 0;

    int popcornPrice = 300;
    int nachosPrice = 250;
    int drinkPrice = 200;
    int candyPrice = 150;

    TextView qtyPopcorn, qtyNachos, qtyDrink, qtyCandy, snackTotalText;
    AppCompatButton confirmSnackBtn;

    String movieName;
    int seatCount;
    int ticketTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        receiveSeatData();
        initializeViews();
        setupListeners();
    }

    private void receiveSeatData() {
        movieName = getIntent().getStringExtra("movie_name");
        seatCount = getIntent().getIntExtra("seat_count", 0);
        ticketTotal = getIntent().getIntExtra("ticket_total", 0);
    }

    private void initializeViews() {
        qtyPopcorn = findViewById(R.id.qtyPopcorn);
        qtyNachos = findViewById(R.id.qtyNachos);
        qtyDrink = findViewById(R.id.qtyDrink);
        qtyCandy = findViewById(R.id.qtyCandy);

        snackTotalText = findViewById(R.id.snackTotalText);
        confirmSnackBtn = findViewById(R.id.confirmSnackBtn);
    }

    private void setupListeners() {

        findViewById(R.id.plusPopcorn).setOnClickListener(v -> {
            popcornQty++;
            qtyPopcorn.setText(String.valueOf(popcornQty));
            updateSnackTotal();
        });

        findViewById(R.id.minusPopcorn).setOnClickListener(v -> {
            if (popcornQty > 0) {
                popcornQty--;
                qtyPopcorn.setText(String.valueOf(popcornQty));
                updateSnackTotal();
            }
        });

        findViewById(R.id.plusNachos).setOnClickListener(v -> {
            nachosQty++;
            qtyNachos.setText(String.valueOf(nachosQty));
            updateSnackTotal();
        });

        findViewById(R.id.minusNachos).setOnClickListener(v -> {
            if (nachosQty > 0) {
                nachosQty--;
                qtyNachos.setText(String.valueOf(nachosQty));
                updateSnackTotal();
            }
        });

        findViewById(R.id.plusDrink).setOnClickListener(v -> {
            drinkQty++;
            qtyDrink.setText(String.valueOf(drinkQty));
            updateSnackTotal();
        });

        findViewById(R.id.minusDrink).setOnClickListener(v -> {
            if (drinkQty > 0) {
                drinkQty--;
                qtyDrink.setText(String.valueOf(drinkQty));
                updateSnackTotal();
            }
        });

        findViewById(R.id.plusCandy).setOnClickListener(v -> {
            candyQty++;
            qtyCandy.setText(String.valueOf(candyQty));
            updateSnackTotal();
        });

        findViewById(R.id.minusCandy).setOnClickListener(v -> {
            if (candyQty > 0) {
                candyQty--;
                qtyCandy.setText(String.valueOf(candyQty));
                updateSnackTotal();
            }
        });

        confirmSnackBtn.setOnClickListener(v -> {

            int snackTotal =
                    (popcornQty * popcornPrice) +
                            (nachosQty * nachosPrice) +
                            (drinkQty * drinkPrice) +
                            (candyQty * candyPrice);

            Intent intent = new Intent(SnacksActivity.this, SummaryActivity.class);

            intent.putExtra("movie_name", movieName);
            intent.putExtra("seat_count", seatCount);
            intent.putExtra("ticket_total", ticketTotal);
            intent.putExtra("snack_total", snackTotal);

            startActivity(intent);
            finish(); // IMPORTANT
        });
    }

    private void updateSnackTotal() {
        int snackTotal =
                (popcornQty * popcornPrice) +
                        (nachosQty * nachosPrice) +
                        (drinkQty * drinkPrice) +
                        (candyQty * candyPrice);

        snackTotalText.setText("Snacks Total: Rs " + snackTotal);
    }
}
