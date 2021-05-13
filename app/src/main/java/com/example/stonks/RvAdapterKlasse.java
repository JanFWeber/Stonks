package com.example.stonks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvAdapterKlasse extends RecyclerView.Adapter<RvAdapterKlasse.ViewHolderKlasse> {


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

        holder.itemTextView.setText(MainActivity.itemName.get(position));
        holder.itemImageView.setImageResource(MainActivity.itemLogo.get(position));
        holder.itemTextViewPreis.setText(MainActivity.itemPreis.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });



    }

    @Override
    public int getItemCount() {


        return MainActivity.itemName.size();
    }
}
