package com.example.BroadcastTest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {
    public  static String INTENT_ACTION = "MyBroadcast";
    private android.content.BroadcastReceiver receiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(MyActivity.INTENT_ACTION)){


                Log.i("DOWN", "bad mood");
            }
        }
    };
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btnSend = (Button) findViewById(R.id.btn_send_broadcast);
        registerReceiver(receiver,new IntentFilter(INTENT_ACTION));    //一定要先注册
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(INTENT_ACTION);
//                startActivity(new Intent(MyActivity.this, com.example.BroadcastTest.BroadcastReceiver.class));
                sendBroadcast(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }
}
