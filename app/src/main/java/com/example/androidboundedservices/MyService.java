package com.example.androidboundedservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    public class LocalService extends Binder{

        MyService getService()
        {
            return MyService.this;
        }
    }

    IBinder binder=new LocalService();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
 //   Date cuurentdate= Calendar.getInstance().getTime();
  //  String currentDate= new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
   // Random random=new Random();
     SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd\nHH:mm:ss",Locale.getDefault());
     String currentDateTime=simpleDateFormat.format(new Date());
     String getRandomnumber(){
         return  currentDateTime;
       // return random.nextInt(100);
      //  return currentDate;
    }

}
