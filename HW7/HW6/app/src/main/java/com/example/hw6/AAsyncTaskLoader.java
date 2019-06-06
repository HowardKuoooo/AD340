package com.example.hw6;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

//Refer from in class code

public class AAsyncTaskLoader extends AsyncTaskLoader<String> {

    private String queryString;

    public AAsyncTaskLoader(Context context, String queryString){
        super(context);

        this.queryString = queryString;
    }

    @Nullable
    @Override
    public String loadInBackground() {

        String URL = "https://web6.seattle.gov/Travelers/api/Map/Data?zoomId=13&type=2";

        return NetWorkConnection.getData(URL);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
