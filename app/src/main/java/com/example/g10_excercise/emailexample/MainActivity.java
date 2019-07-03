package com.example.g10_excercise.emailexample;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.g10_excercise.R;

import java.util.List;
import java.util.Random;

public class

MainActivity extends Activity {
    String AudioSavePathInDevice = null;
    String RandomAudioFileName = "ABCDEFGHIJKLMNOP";
    Random random ;
    public static final int RequestPermissionCode = 1;
    MediaRecorder mediaRecorder ;
    private Button buttonStop ,buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startBtn = (Button) findViewById(R.id.button3);
        Button startbtn = (Button) findViewById(R.id.button4);
        Button record = findViewById(R.id.button7);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });
        startbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                map();
            }
        });
    }
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"guptanarendra1998@gmail.com"};
        String[] CC = {"narendra"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"subject" );
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }


    protected void map(){
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

// Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

// Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }
}
