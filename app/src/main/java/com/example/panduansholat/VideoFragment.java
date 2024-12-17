package com.example.panduansholat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    private static final String[] VIDEO_IDS = {
            "6PDFgDcoj-I",
            "oPJG1XntOmo",
            "JYRgjENNkw8",
            "bZ11ZceIKn8"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        WebView webView1 = view.findViewById(R.id.webView1);
        WebView webView2 = view.findViewById(R.id.webView2);
        WebView webView3 = view.findViewById(R.id.webView3);
        WebView webView4 = view.findViewById(R.id.webView4);

        setUpWebView(webView1, VIDEO_IDS[0]);
        setUpWebView(webView2, VIDEO_IDS[1]);
        setUpWebView(webView3, VIDEO_IDS[2]);
        setUpWebView(webView4, VIDEO_IDS[3]);

        return view;
    }

    private void setUpWebView(WebView webView, String videoId) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        String embedCode = "<iframe width=\"100%\" height=\"300\" src=\"https://www.youtube.com/embed/" + videoId + "?autoplay=0&controls=1\" frameborder=\"0\" allowfullscreen></iframe>";

        webView.loadData("<html><body>" + embedCode + "</body></html>", "text/html", "UTF-8");
    }
}