package com.example.practicageneral;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    /*este metodo es llamado cuando se inicial el servicio, si no hay bind, retorna null*/
    @Override
    public IBinder onBind(Intent intent) {
        //sin bind
        return null;
    }

    /*The system calls this method when another component, such as an activity,
    requests that the service be started, by calling startService(). */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;//???

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}
