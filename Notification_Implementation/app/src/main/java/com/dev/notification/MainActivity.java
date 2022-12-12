package com.dev.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String CHANEL_ID = "My Chanel";
    private static final int NOTIFICATION_ID = 100;

    Button notification;
    Notification messageNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = findViewById(R.id.notification);

        //for img collecting
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.a, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeicon = bitmapDrawable.getBitmap();

        // For notification code
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            messageNotification = new Notification.Builder(this)
                    .setLargeIcon(largeicon)
                    .setSmallIcon(R.drawable.a)
                    .setContentText("This is a message from Developer Md. Waliul Islam Rayhan")
                    .setSubText("New Notification")
                    .setChannelId(CHANEL_ID)
                    .build();

            notificationManager.createNotificationChannel(new NotificationChannel(CHANEL_ID,"New Chanel", NotificationManager.IMPORTANCE_HIGH));
        }


        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(NOTIFICATION_ID, messageNotification);

            }
        });

    }
}