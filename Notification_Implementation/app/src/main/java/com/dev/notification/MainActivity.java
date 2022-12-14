package com.dev.notification;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String CHANEL_ID = "My Chanel";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQ_ID = 100;

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


        //intent open
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);



//        Big Picture Style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(), R.drawable.a, null))).getBitmap())
                .bigLargeIcon(largeicon)
                .setBigContentTitle("Hello Tester")
                .setSummaryText("This is the summary text");


        // For notification code
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            messageNotification = new Notification.Builder(this)
                    .setLargeIcon(largeicon)
                    .setSmallIcon(R.drawable.a)
                    .setContentText("This is a message from Developer Md. Waliul Islam Rayhan")
                    .setSubText("New Notification")
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
                    .setChannelId(CHANEL_ID)
                    .build();

            notificationManager.createNotificationChannel(new NotificationChannel(CHANEL_ID, "New Chanel", NotificationManager.IMPORTANCE_HIGH));
        }


        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(NOTIFICATION_ID, messageNotification);
//                Toast toast= Toast.makeText(getApplicationContext(), "Your string here", Toast.LENGTH_SHORT);
//                toast.show();
            }
        });

    }
}