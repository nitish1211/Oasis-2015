package v2015.oasis.pilani.bits.com.home;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sponsors extends android.support.v4.app.Fragment {
    ProgressBar loading;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_sponsors, container, false);
        loading=(ProgressBar) view.findViewById(R.id.loading);
        loading.setMax(100);

        WebView web = (WebView) view.findViewById(R.id.web);
        web.getSettings().setAllowFileAccess(true);
        WebSettings ws = web.getSettings();
        ws.setSaveFormData(true);
        ws.setJavaScriptEnabled(true);
        ws.setSavePassword(true);
        ws.setLoadWithOverviewMode(true);
        ws.setUseWideViewPort(true);
        ws.setAppCacheMaxSize(2048 * 2048);
        ws.setAppCachePath(getActivity().getCacheDir().getAbsolutePath());
        ws.setAppCacheEnabled(true);

        web.setWebViewClient(new mwebViewClient());

        if(!isNetworkAvailable())
        {
            Toast.makeText(getActivity(),"No Internet Connectivity",Toast.LENGTH_LONG).show();
            return view;
        }

        web.loadUrl("http://bits-oasis.org/sponsors/");


        return view;
    }
    private class mwebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            loading.setProgress(40);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            loading.setVisibility(View.GONE);
        }
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    }

