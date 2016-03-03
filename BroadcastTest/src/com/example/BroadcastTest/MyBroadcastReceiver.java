package com.example.BroadcastTest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by ppzhou on 2015/11/20.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(MyActivity.INTENT_ACTION)){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, "aaa", Toast.LENGTH_SHORT).show();  //���Ե�toast
//                        Activity activity = (Activity) context;
//                        activity.finish();
//                        �޷�ת�� android.app.ReceiverRestrictedContext cannot be cast to android.app.Activity
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);   //ȫ��dialog ������������activity ������premission
        alert.show();
        }

    }
}
