package com.example.hw6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

//Refer from in class code
//Refer from https://www.programcreek.com/java-api-examples/android.net.ConnectivityManager
//Refer from https://www.youtube.com/watch?v=Vyqz_-sJGFk&t=444s
//Refer from https://www.youtube.com/watch?v=tgQbLEckNIo

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks <String> {


    private TextView results;
    public String TAG = "Camera RecyclerView";
    public RecyclerViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        ConnectivityManager conManager = (ConnectivityManager) getSystemService ( Context.CONNECTIVITY_SERVICE );
        NetworkInfo info = conManager.getActiveNetworkInfo ();

        if (info != null && info.isConnected ()) {

            Bundle bundle = new Bundle ();
            getSupportLoaderManager ().restartLoader ( 0, bundle, this );

        } else {

            Toast toast = Toast.makeText(this, getResources().getString(R.string.my_resource_string), Toast.LENGTH_SHORT);
            toast.show();

        }

    }

    @Override
    public void onClick(View v) {

        //results.setText ( getResources ().getString ( R.string.waiting) );
        //Bundle bundle = new Bundle ( );
        //bundle.putString ("queryString", "gettyburg");
        //getSupportLoaderManager ().restartLoader ( 0, bundle,this);
        //String url = "https://raw.githubusercontent.com/telpirion/AD340/master/notes/web_content.txt";
        //new GitHubAsyncTask ( results ).execute ( url );

    }

    @NonNull
    @Override
    public Loader <String> onCreateLoader(int i, @Nullable Bundle bundle) {

        String queryString = "";

        if (bundle != null) {
            queryString = bundle.getString ( "queryString" );
        }

        return new AAsyncTaskLoader ( this, queryString );

    }

    public void onLoadFinished(@NonNull Loader <String> loader, String s) {

        try {

            JSONObject jasonObject = new JSONObject ( s );

            //get json array node
            JSONArray features = jasonObject.getJSONArray ( "Features" );

            // get the length of json array
            Camera[] camerasList = new Camera[features.length ()];

            for (int i = 0; i < features.length (); i++) {
                JSONObject c = features.getJSONObject ( i );
                JSONArray cameras = c.getJSONArray ( "Cameras" );
                JSONObject indexZero = cameras.getJSONObject ( 0 );

                camerasList[i] = new Camera (
                        indexZero.getString ( "Id" ),
                        indexZero.getString ( "Description" ),
                        indexZero.getString ( "ImageUrl"),
                        indexZero.getString ( "Type" )
                );
            }

            RecyclerView recyclerView = (RecyclerView) findViewById ( R.id.recyclerv_view );
            recyclerView.setHasFixedSize ( true );

            recyclerView.setLayoutManager ( new LinearLayoutManager ( this ));
            recyclerView.setAdapter ( new RecyclerViewAdapter ( camerasList ) );

        } catch (Exception e) {
            Log.e ( TAG, e.getLocalizedMessage () );
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader <String> loader) {

    }

}
