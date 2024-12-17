package com.example.panduansholat;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class NiatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NiatSholatAdapter adapter;
    private List<NiatSholatModel> sholatList;

    private WebView webView6;

    private static final String VIDEO_ID = "G4ZdBk6wm5o";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niat);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        webView6 = findViewById(R.id.webView6);

        setUpWebView(webView6, VIDEO_ID);
        loadJson();
    }

    private void setUpWebView(WebView webView, String videoId) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        String embedCode = "<iframe width=\"100%\" height=\"300\" src=\"https://www.youtube.com/embed/" + videoId + "?autoplay=0&controls=1\" frameborder=\"0\" allowfullscreen></iframe>";
        webView.loadData("<html><body>" + embedCode + "</body></html>", "text/html", "UTF-8");
    }

    private void loadJson() {
        String json = null;
        try {
            InputStream is = getAssets().open("niat_sholat.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        Gson gson = new Gson();
        Type listType = new TypeToken<List<NiatSholatModel>>() {}.getType();
        sholatList = gson.fromJson(json, listType);

        adapter = new NiatSholatAdapter(this, sholatList);
        recyclerView.setAdapter(adapter);
    }
}
