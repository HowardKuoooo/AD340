package com.example.hw6;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import android.support.v4.app.LoaderManager;



// Refer from HW3 adapter

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.ViewHolder> implements LoaderManager.LoaderCallbacks <String> {

    private static final String TAG = "RecyclerViewAdapter";

    private Listener listener;
    private Camera[] cameras;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    interface Listener { void onClick(int position);}

    public RecyclerViewAdapter(Camera[] cameras) {
        this.cameras = cameras;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView layout;

        public ViewHolder(CardView v) {
            super ( v );
            layout = v;
        }
    }

    @Override
    public int getItemCount() { return cameras.length; }

    @NonNull
    @Override
    public Loader <String> onCreateLoader(int i, @Nullable Bundle bundle) {return null; }

    @Override
    public void onLoadFinished(@NonNull Loader <String> loader, String s) { }

    @Override
    public void onLoaderReset(@NonNull Loader <String> loader) { }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder ( (CardView) LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.recyclerview, parent, false ) );


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        TextView camName;
        ImageView image;

        CardView cardView = holder.layout;
        Context context = cardView.getContext();
        camName = (TextView) cardView.findViewById ( R.id.camera_name );
        image = (ImageView) cardView.findViewById ( R.id.image );


        Camera cam = cameras[position];
        camName.setText ( cam.getDiscription () );
        Picasso.get ().load ( cam.getUrl () ).into ( image );


    }

}
