public class NowShowingFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Movie> movieList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_now_showing, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        movieList = new ArrayList<>();


        movieList.add(new Movie("Inception", "Sci-Fi", R.drawable.inception));
        movieList.add(new Movie("Interstellar", "Sci-Fi", R.drawable.interstellar));
        movieList.add(new Movie("Dark Knight", "Action", R.drawable.dark_knight));

        MovieAdapter adapter = new MovieAdapter(getContext(), movieList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}