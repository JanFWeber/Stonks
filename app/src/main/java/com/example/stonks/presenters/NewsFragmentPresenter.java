package com.example.stonks.presenters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stonks.R;
import com.example.stonks.views.fragments.NewsFragment;

public class NewsFragmentPresenter extends RecyclerView.Adapter<NewsFragmentPresenter.ViewHolderKlasse2> {

    public class ViewHolderKlasse2 extends RecyclerView.ViewHolder {
        TextView textViewNews;
        ImageView imageViewNews;


        public ViewHolderKlasse2(@NonNull @org.jetbrains.annotations.NotNull View newsView) {
            super(newsView);
            textViewNews = (TextView) newsView.findViewById(R.id.textViewNews);
            imageViewNews = (ImageView) newsView.findViewById(R.id.imageViewNews);

        }

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolderKlasse2 onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        View newsView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout2, null);

        return new ViewHolderKlasse2(newsView1);

    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewHolderKlasse2 holder2, int position) {

        holder2.textViewNews.setText(NewsFragment.newsNachricht.get(position));
        holder2.imageViewNews.setImageResource(NewsFragment.newsLogo.get(position));










    }

    @Override
    public int getItemCount() {


        return NewsFragment.newsNachricht.size();
    }








}




    /*
    muss von api neue Nachrichten bekommen und diese dann auf das "NewsFragment" setzten
        => Forgefertigte Kästen in denen die Nachrichten angezeigt werden mit löschoption beim wischen
    Ggf. Vermittlung zum Speicher wenn wir nicht nur aktuelle, sondern auch vergangene Nachrichten speichern und anzeigen wollen
     */

