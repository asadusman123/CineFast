package com.example.cinefast2_23l_0740;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SeatSelectionFragment extends Fragment {

    TextView movieTitle, seatCountText, totalPriceText;
    Button proceedBtn, bookNowBtn, comingSoonBtn, watchTrailerBtn;

    int selectedSeats = 0;
    int ticketPrice = 500;

    String movieName, type;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_seat_selection, container, false);

        // RECEIVE DATA
        if (getArguments() != null) {
            movieName = getArguments().getString("movie_name");
            type = getArguments().getString("type");
        }

        movieTitle = view.findViewById(R.id.movieTitle);
        seatCountText = view.findViewById(R.id.seatCountText);
        totalPriceText = view.findViewById(R.id.totalPriceText);

        proceedBtn = view.findViewById(R.id.proceedBtn);
        bookNowBtn = view.findViewById(R.id.bookNowBtn);

        movieTitle.setText(movieName);

        if (type != null && type.equals("coming")) {
            handleComingSoon(view);
        } else {
            handleNowShowing(view);
        }

        return view;
    }

    // ================= NOW SHOWING =================

    private void handleNowShowing(View view) {

        Button[] seats = new Button[12];

        for (int i = 0; i < 12; i++) {
            int resID = getResources().getIdentifier("seat" + (i + 1), "id", requireContext().getPackageName());
            seats[i] = view.findViewById(resID);
        }

        for (Button seat : seats) {
            if (seat == null) continue;
            seat.setOnClickListener(v -> {

                if (seat.isSelected()) {
                    seat.setSelected(false);
                    seat.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
                    selectedSeats--;
                } else {
                    seat.setSelected(true);
                    seat.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    selectedSeats++;
                }

                updateUI();
            });
        }

        proceedBtn.setOnClickListener(v -> {
            SnacksFragment fragment = new SnacksFragment();
            ((MainActivity) requireActivity()).loadFragment(fragment);
        });

        bookNowBtn.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Booking Confirmed!", Toast.LENGTH_SHORT).show();

            TicketSummaryFragment fragment = new TicketSummaryFragment();
            ((MainActivity) requireActivity()).loadFragment(fragment);
        });
    }

    // ================= COMING SOON =================

    private void handleComingSoon(View view) {

        // Hide old buttons
        proceedBtn.setVisibility(View.GONE);
        bookNowBtn.setVisibility(View.GONE);

        // Create new buttons
        comingSoonBtn = new Button(getContext());
        comingSoonBtn.setText("Coming Soon");
        comingSoonBtn.setEnabled(false);

        watchTrailerBtn = new Button(getContext());
        watchTrailerBtn.setText("Watch Trailer");

        ViewGroup layout = view.findViewById(R.id.seatGrid).getParent() instanceof ViewGroup ? 
                (ViewGroup) view.findViewById(R.id.seatGrid).getParent() : (ViewGroup) view;
        
        layout.addView(comingSoonBtn);
        layout.addView(watchTrailerBtn);

        watchTrailerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.youtube.com"));
            startActivity(intent);
        });
    }

    private void updateUI() {
        seatCountText.setText("Seats: " + selectedSeats);
        totalPriceText.setText("Total: Rs " + (selectedSeats * ticketPrice));
        proceedBtn.setEnabled(selectedSeats > 0);
    }
}
