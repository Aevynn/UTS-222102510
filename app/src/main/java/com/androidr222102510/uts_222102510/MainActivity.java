package com.androidr222102510.uts_222102510;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.ParameterName;

public class MainActivity extends AppCompatActivity {
    private Button _informasiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInformasiButton();

    }

    private void initInformasiButton() {
        _informasiButton = findViewById(R.id.informasiButton);

        _informasiButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NotificationChannel channel = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    channel = new NotificationChannel("rbChannel", "RB", NotificationManager.IMPORTANCE_DEFAULT);
                }

                NotificationCompat.Builder builder = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    builder = new NotificationCompat.Builder(getApplicationContext())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Notifikasi")
                            .setContentText("222102510 Rivaldo Briliandy")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setChannelId(channel.getId());
                }

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    manager.createNotificationChannel(channel);
                }
                manager.notify(1, builder.build());
            }
        });
    }
    }
