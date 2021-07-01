package com.example.androidboundedservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    MyService myService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
       // int no=myService.getRandomnumber();
        String date=myService.getRandomnumber();
        TextView txt1=findViewById(R.id.output);
       // txt1.setText(String.valueOf(no));

        txt1.setText(date);
    }

    @Override
    protected void onStart() {
        Intent intent=new Intent(MainActivity.this,MyService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);

        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mConnection);
    }

    ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            MyService.LocalService localService=(MyService.LocalService)service;
            myService=localService.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}