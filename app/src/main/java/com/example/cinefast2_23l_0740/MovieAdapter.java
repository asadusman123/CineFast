package com.example.cinefast2_23l_0740;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    ArrayList<Movie> movieList;
    Context context;

    public MovieAdapter(Context context, ArrayList<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, genre;
        Button bookBtn, trailerBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.movieImage);
            name = itemView.findViewById(R.id.movieName);
            genre = itemView.findViewById(R.id.movieGenre);
            bookBtn = itemView.findViewById(R.id.bookBtn);
            trailerBtn = itemView.findViewById(R.id.trailerBtn);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Movie movie = movieList.get(position);

        holder.name.setText(movie.getName());
        holder.genre.setText(movie.getGenre());
        holder.image.setImageResource(movie.getImage());

        holder.bookBtn.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity.class);

            // We'll improve this later using fragments properly
            intent.putExtra("movie_name", movie.getName());

            context.startActivity(intent);
        });

        holder.trailerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.youtube.com"));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}