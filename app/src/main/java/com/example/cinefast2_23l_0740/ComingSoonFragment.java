package com.example.cinefast2_23l_0740;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ComingSoonFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Movie> movieList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_coming_soon, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        movieList = new ArrayList<>();


        movieList.add(new Movie("Inception 2", "Sci-Fi", R.drawable.inception));
        movieList.add(new Movie("Interstellar 2", "Sci-Fi", R.drawable.interstellar));
        movieList.add(new Movie("Dark Knight 2", "Action", R.drawable.dark_knight));

        MovieAdapter adapter = new MovieAdapter(getContext(), movieList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
