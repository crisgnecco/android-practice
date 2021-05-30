package com.example.practicageneral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    String stateTag = "State";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //cargo el layout
        setContentView(R.layout.activity_main);

        /*modificar textView con un string de R*/
        TextView msgTextView = (TextView) findViewById(R.id.mensaje1);
        msgTextView.setText(R.string.hello);

        //Log.d(stateTag, "The onCrate() event");

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
        intent.setAction("CUSTOM_INTENT");

        sendBroadcast(intent);
    }


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
