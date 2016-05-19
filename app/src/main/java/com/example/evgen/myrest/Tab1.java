package com.example.evgen.myrest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by EVGEN on 25.04.2016.
 */
public class Tab1 extends Fragment implements OnClickListener {
    Button table1,table2,table3;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_1,container,false);
        table1 = (Button) v.findViewById(R.id.btab1); table1.setOnClickListener(this);
        table2 = (Button) v.findViewById(R.id.btab2); table2.setOnClickListener(this);
        table3 = (Button) v.findViewById(R.id.btab4); table3.setOnClickListener(this);


        return v;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btab1:

                Toast.makeText(getActivity(), "button1", Toast.LENGTH_SHORT).show();
                // button1.clearAnimation();
                table1.setVisibility(View.INVISIBLE);
                break;

        }
    }
}