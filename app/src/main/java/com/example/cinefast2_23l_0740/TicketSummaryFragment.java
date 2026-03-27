package com.example.cinefast2_23l_0740;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TicketSummaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TicketSummaryFragment extends Fragment {

    TextView summaryText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ticket_summary, container, false);

        summaryText = view.findViewById(R.id.summaryText);

        // Example values (we'll improve later if needed)
        String movie = "Sample Movie";
        int seats = 2;
        int total = 1000;

        summaryText.setText(
                "Movie: " + movie +
                        "\nSeats: " + seats +
                        "\nTotal: Rs " + total
        );

        // SAVE TO SHARED PREFERENCES
        SharedPreferences prefs = requireActivity().getSharedPreferences("booking", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("movie", movie);
        editor.putInt("seats", seats);
        editor.putInt("total", total);

        editor.apply();

        return view;
    }
}
