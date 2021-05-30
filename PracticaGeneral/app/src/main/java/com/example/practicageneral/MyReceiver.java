package com.example.practicageneral;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    /* This method is called when the BroadcastReceiver is receiving an Intent broadcast. */
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "broadcast intent recibido", Toast.LENGTH_LONG).show();
    }
}
