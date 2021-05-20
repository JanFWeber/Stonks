package com.example.stonks.presenters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stonks.R;

import com.example.stonks.views.fragments.TrendingFragment;

public class TrendingFragmentPresenter extends RecyclerView.Adapter<TrendingFragmentPresenter.ViewHolderKlasse3> {

    public class ViewHolderKlasse3 extends RecyclerView.ViewHolder {
        TextView textViewKurs;
        TextView textViewName;
        ImageView imageViewLogoT;

        public ViewHolderKlasse3(@NonNull @org.jetbrains.annotations.NotNull View trendingView) {
            super(trendingView);
            textViewKurs = (TextView) trendingView.findViewById(R.id.textViewKurs);
            textViewName = (TextView) trendingView.findViewById(R.id.textViewName);
            imageViewLogoT = (ImageView) trendingView.findViewById(R.id.imageViewLogoT);
        }

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public TrendingFragmentPresenter.ViewHolderKlasse3 onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        View trendingView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_layout2, null);

        return new TrendingFragmentPresenter.ViewHolderKlasse3(trendingView1);

    }


    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull TrendingFragmentPresenter.ViewHolderKlasse3 holder3, int position) {

        holder3.textViewKurs.setText(TrendingFragment.trendingKurs.get(position));
        holder3.textViewName.setText(TrendingFragment.trendingName.get(position));
        holder3.imageViewLogoT.setImageResource(TrendingFragment.trendingLogo.get(position));










    }


    @Override
    public int getItemCount() {


        return TrendingFragment.trendingKurs.size();
    }



    /*
    Gibt es eine "Trending Seite" die wir von der api bekommen können?
        Falls nicht, würde ich besonders diesen Teil nicht impleentieren sondern nur die Idee dahinter Vorstellen
        Theoretisch können wir die Volatilsten Aktien vom HomeFragment vergleichen
     */
}
