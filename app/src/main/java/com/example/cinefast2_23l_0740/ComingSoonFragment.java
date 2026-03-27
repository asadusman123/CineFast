public class NowShowingFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Movie> movieList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_now_showing, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        movieList = new ArrayList<>();


        movieList.add(new Movie("Avatar 3", "Sci-Fi", R.drawable.avatar));
        movieList.add(new Movie("Avengers 5", "Action", R.drawable.avengers));
        movieList.add(new Movie("Dune Part 3", "Sci-Fi", R.drawable.dune));

        MovieAdapter adapter = new MovieAdapter(getContext(), movieList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}