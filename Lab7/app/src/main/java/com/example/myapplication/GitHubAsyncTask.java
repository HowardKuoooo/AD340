package com.example.myapplication;

import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GitHubAsyncTask extends AsyncTask<String, Void, String> {

    private WeakReference<TextView> mTextView;

    //Work not on the UI thread
    public GitHubAsyncTask(TextView textView){
        this.mTextView = new WeakReference<> (textView);

    }


    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection urlCommection = null;
        BufferedReader reader = null;
        String results = "";

        try {
            URL requestURL = new URL (strings[0]);

            urlCommection = (HttpURLConnection) requestURL.openConnection ();
            urlCommection.setRequestMethod ("GET");
            urlCommection.connect ();
            ;

            //Get the IuptStream
            InputStream inputStream = urlCommection.getInputStream ();

            //Create a buffered reader
            reader = new BufferedReader ( new InputStreamReader ( inputStream ) {
                @Override
                public int read() throws IOException {
                    return 0;
                }
            } );

            //Use a StringBuilder
            StringBuilder builder = new StringBuilder ();

            String line;
            while ((line = reader.readLine ()) != null) {
                builder.append (line);
            }
            results = builder.toString ();
        } catch (IOException e) {
            e.printStackTrace ();
        } finally{
            if(urlCommection != null){
                urlCommection.disconnect ();
            } if (reader != null){
                try {
                    reader.close ();
                }catch (IOException e){
                    e.printStackTrace ();
                }

            }

        }
        return results;
    }

}
