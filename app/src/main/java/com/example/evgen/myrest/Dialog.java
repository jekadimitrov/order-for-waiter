package com.example.evgen.myrest;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
/**
 * Created by EVGEN on 25.04.2016.
 */
public class Dialog extends DialogFragment implements OnClickListener {

    final String LOG_TAG = "myLogs";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Title!");
        View v = inflater.inflate(R.layout.dialog, null);
        v.findViewById(R.id.btnYes).setOnClickListener(this);
         v.findViewById(R.id.btnNo).setOnClickListener(this);

        return v;
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnYes:
            Intent intent = new Intent(getContext(), MessageOrder.class);
            startActivity(intent);
                break;
            case R.id.btnNo:

                dismiss();
                break;
        }
    }


    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog 1: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }
}