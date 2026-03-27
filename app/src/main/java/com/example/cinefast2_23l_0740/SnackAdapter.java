package com.example.cinefast2_23l_0740;

public class SnackAdapter extends BaseAdapter {

    Context context;
    ArrayList<Snack> snackList;

    public SnackAdapter(Context context, ArrayList<Snack> snackList) {
        this.context = context;
        this.snackList = snackList;
    }

    @Override
    public int getCount() {
        return snackList.size();
    }

    @Override
    public Object getItem(int position) {
        return snackList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.snack_item, parent, false);
        }

        Snack snack = snackList.get(position);

        ImageView image = convertView.findViewById(R.id.snackImage);
        TextView name = convertView.findViewById(R.id.snackName);
        TextView price = convertView.findViewById(R.id.snackPrice);
        TextView qty = convertView.findViewById(R.id.quantityText);
        Button plus = convertView.findViewById(R.id.plusBtn);
        Button minus = convertView.findViewById(R.id.minusBtn);

        image.setImageResource(snack.getImage());
        name.setText(snack.getName());
        price.setText("Rs " + snack.getPrice());
        qty.setText(String.valueOf(snack.getQuantity()));

        plus.setOnClickListener(v -> {
            snack.setQuantity(snack.getQuantity() + 1);
            qty.setText(String.valueOf(snack.getQuantity()));
        });

        minus.setOnClickListener(v -> {
            if (snack.getQuantity() > 0) {
                snack.setQuantity(snack.getQuantity() - 1);
                qty.setText(String.valueOf(snack.getQuantity()));
            }
        });

        return convertView;
    }
}
