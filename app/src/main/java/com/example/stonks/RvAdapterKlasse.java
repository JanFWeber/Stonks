package com.example.stonks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stonks.models.Item;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RvAdapterKlasse extends RecyclerView.Adapter<RvAdapterKlasse.ViewHolderKlasse> {


    private ArrayList<Item> stockArrayList;

    private IDetailView detailView;

    public class ViewHolderKlasse extends RecyclerView.ViewHolder {
        TextView itemTextView;
        ImageView itemImageView;
        TextView itemTextViewPreis;


        public ViewHolderKlasse(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            itemTextView = (TextView) itemView.findViewById(R.id.textViewAktie);
            itemImageView = (ImageView) itemView.findViewById(R.id.imageViewLogo);
            itemTextViewPreis = (TextView) itemView.findViewById(R.id.textViewPreis);
        }

        public void setStock(Item item) {
            itemTextView.setText(item.getName());
            Picasso.get().load(item.getLogoURL()).into(itemImageView);
            //Formatierung von float zu String mit 2 Nachkommastellen
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            //String value = decimalFormat.format(item.getValue());
            String value = decimalFormat.format(item.getValue());
            itemTextViewPreis.setText(value);
        }
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolderKlasse onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View itemView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.aktien_layout1, null);
        return new ViewHolderKlasse(itemView1);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewHolderKlasse holder, int position) {
        Item item = stockArrayList.get(position);
        holder.setStock(item);
        /*holder.itemTextView.setText(HomeFragment.
        holder.itemImageView.setImageResource(HomeFragment.itemLogo.get(position));
        holder.itemTextViewPreis.setText(HomeFragment.itemPreis.get(position)); */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailView.showDetails(item.getSymbol());
            }
        });
    }

    @Override
    public int getItemCount() {
        return stockArrayList.size();
    }

    public void updateList(ArrayList<Item> stockArrayList) {
        this.stockArrayList = stockArrayList;

        notifyDataSetChanged();
    }
}
