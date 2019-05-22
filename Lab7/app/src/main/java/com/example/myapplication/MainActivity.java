package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, LoaderManager.LoaderCallbacks<String> {

    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Button button = findViewById (R.id.btn_get_data);
        button.setOnClickListener (this);

        results = findViewById (R.id.lbl_results);

    }



    @Override
    public void onClick(View view) {
        results.setText ( getResources ().getString ( R.string.waiting) );

        Bundle bundle = new Bundle ( );
        bundle.putString ("queryString", "gettyburg");
        getSupportLoaderManager ().restartLoader ( 0, bundle,this);

        //String url = "https://raw.githubusercontent.com/telpirion/AD340/master/notes/web_content.txt";
       //new GitHubAsyncTask ( results ).execute ( url );
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @NonNull Bundle bundle){
        String queryString = "";
        if(bundle != null){
            queryString = bundle.getString ( "queryString" );
        }
        return new LOCAsyncTaskLoader ( this, queryString);
    }
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s){
        results.setText (s);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader){

    }

}
