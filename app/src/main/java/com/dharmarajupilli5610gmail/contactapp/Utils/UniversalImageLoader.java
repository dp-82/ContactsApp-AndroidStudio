package com.dharmarajupilli5610gmail.contactapp.Utils;

import android.content.Context;

import com.dharmarajupilli5610gmail.contactapp.R;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class UniversalImageLoader {
    private static final int defaultImage=R.drawable.ic_android;
    private Context mcontext;

    public UniversalImageLoader(Context mcontext) {
        this.mcontext = mcontext;
    }
}
