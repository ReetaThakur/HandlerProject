package com.example.handlerproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MyService extends Service {
    private String name="";

    public MyService() {

    }
    private Runnable task=new Runnable() {
        @Override
        public void run() {
            saveToFile();

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent!=null){
            name=intent.getStringExtra("name");
        }
        launchBackGroundThread();
        return super.onStartCommand(intent, flags, startId);

    }

    private void launchBackGroundThread() {
        Thread thread=new Thread(task);
        thread.start();
    }
    private void saveToFile(){
        try {
            File directory = new File(getFilesDir() + File.separator + "NameFolder");
            if (!directory.exists()) {
                directory.mkdir();
            }
            File file = new File(directory, "name.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream=new FileOutputStream(file,true);
            OutputStreamWriter writer= new OutputStreamWriter(fileOutputStream);
            writer.append(name+"\n");
            writer.close();
        }catch (Exception e){

        }
    }
}