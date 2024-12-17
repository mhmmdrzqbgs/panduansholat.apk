package com.example.panduansholat;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

public class SplashActivity extends AppCompatActivity {
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Mengaktifkan mode tepi-ke-tepi
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        // Mulai animasi
        ImageView loadingImage = findViewById(R.id.loading_image);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        loadingImage.startAnimation(rotateAnimation);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}