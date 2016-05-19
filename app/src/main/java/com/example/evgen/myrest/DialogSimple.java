package com.example.evgen.myrest;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by EVGEN on 27.04.2016.
 */
public class DialogSimple extends DialogFragment implements View.OnClickListener {
    final String LOG_TAG = "myLogs";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Title!");
        View v = inflater.inflate(R.layout.dialog_simple, null);
        v.findViewById(R.id.taxi).setOnClickListener(this);
        v.findViewById(R.id.mapt).setOnClickListener(this);

        return v;
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.taxi:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0487007007"));
                startActivity(callIntent);
                break;
            case R.id.mapt:

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