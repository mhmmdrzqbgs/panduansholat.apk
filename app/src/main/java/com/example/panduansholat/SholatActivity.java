package com.example.panduansholat;

import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SholatActivity extends AppCompatActivity {

    private List<SholatModel> itemsholat;
    private RecyclerView recyclerView;
    private WebView webView5;

    private static final String[] VIDEO_IDS = {
            "qAd2Cg-tDo0"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sholat);

        recyclerView = findViewById(R.id.recyclerView);
        webView5 = findViewById(R.id.webView5);

        new LoadJsonTask().execute();

        setUpWebView(webView5, VIDEO_IDS[0]);
    }

    private void setUpWebView(WebView webView, String videoId) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        String embedCode = "<iframe width=\"100%\" height=\"300\" src=\"https://www.youtube.com/embed/" + videoId + "?autoplay=0&controls=1\" frameborder=\"0\" allowfullscreen></iframe>";
        webView.loadData("<html><body>" + embedCode + "</body></html>", "text/html", "UTF-8");
    }

    class LoadJsonTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                InputStream is = getAssets().open("bacaansholat.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                return new String(buffer, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {
            if (json != null) {
                Gson gson = new Gson();
                Type listType = new TypeToken<List<SholatModel>>() {}.getType();
                itemsholat = gson.fromJson(json, listType);
                PutDataIntoRecyclerView(itemsholat);
            } else {
                Toast.makeText(SholatActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void PutDataIntoRecyclerView(List<SholatModel> sholatList) {
        SholatAdapter adapter = new SholatAdapter(this, sholatList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
