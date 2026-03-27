package com.example.cinefast2_23l_0740;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SnacksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SnacksFragment extends Fragment {

    ListView listView;
    Button confirmBtn;
    ArrayList<Snack> snackList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_snacks, container, false);

        listView = view.findViewById(R.id.listView);
        confirmBtn = view.findViewById(R.id.confirmBtn);

        snackList = new ArrayList<>();

        // Add at least 4 snacks
        snackList.add(new Snack("Popcorn", 300, R.drawable.popcorn));
        snackList.add(new Snack("Nachos", 250, R.drawable.nachos));
        snackList.add(new Snack("Drink", 200, R.drawable.drink));
        snackList.add(new Snack("Candy", 150, R.drawable.candy));

        SnackAdapter adapter = new SnackAdapter(getContext(), snackList);
        listView.setAdapter(adapter);

        confirmBtn.setOnClickListener(v -> {
            TicketSummaryFragment fragment = new TicketSummaryFragment();
            ((MainActivity) requireActivity()).loadFragment(fragment);
        });

        return view;
    }
}