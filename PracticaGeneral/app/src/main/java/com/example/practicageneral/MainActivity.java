package com.example.practicageneral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    String stateTag = "State";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //cargo el layout
        setContentView(R.layout.activity_main);

        //modificar textView con un string de R
        //TextView msgTextView = (TextView) findViewById(R.id.mensaje1);
        //msgTextView.setText(R.string.saludo);

        //Log.d(stateTag, "The onCrate() event");


    }

    /** Mostrar estado de bateria en %*/
    public void mostrarEstadoBateria(View view){


        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = getApplicationContext().registerReceiver(null, ifilter);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level * 100 / (float) scale;

        //TextView msgTextView = findViewById(R.id.mensaje1);
        //msgTextView.setText("La bateria esta en " + batteryPct + "%");

        Toast.makeText(getApplicationContext(), "la bateria esta en " + batteryPct + "%", Toast.LENGTH_LONG).show();
        //Context context = getApplicationContext();
        //CharSequence text = "La bateria esta en " + batteryPct + "%";
        //int duration = Toast.LENGTH_SHORT;
        //Toast toast = Toast.makeText(context, text, duration);
        //toast.show();
    }

    public void startService(View view) {
        //servicio sin bind
        startService(new Intent(getBaseContext(), MyService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }


    /** se llama desde boton sendBroadcast en UI*/
    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.example.practicageneral.CUSTOM_INTENT");

        //TODO: no funciona aun.Hay un tema con el nombre del broadcastINtent
        sendBroadcast(intent);
    }

    /** Uso de contentProvider, en este caso una BD SQLite */


/** -------------------------------------------------------------------------------------*/

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(stateTag, "The onStart() event");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(stateTag, "The onResume() event");

        Context context = getApplicationContext();
        CharSequence text = "La bateria esta en %";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(stateTag, "The onPause() event");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(stateTag, "The onStop() event");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(stateTag, "The onDestroy() event");
    }

}
