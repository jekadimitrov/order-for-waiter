package com.example.evgen.myrest;

import android.content.Intent;
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
public class Tab2  extends Fragment  implements OnClickListener{
    DialogFragment dlg1;
    DialogFragment dial4;

    Button button1,button2,button3,button4;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2,container,false);
        button1 = (Button) v.findViewById(R.id.button);
        button4 = (Button) v.findViewById(R.id.button4);
        button1.setOnClickListener(this);
        button4.setOnClickListener(this);
        button2 = (Button) v.findViewById(R.id.button2);
        button3 = (Button) v.findViewById(R.id.button3);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        dlg1 = new Dialog();
        dial4 = new DialogSimple();
        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button:
                dlg1.show(getFragmentManager(), "dlg1");
                Toast.makeText(getActivity(), "button1" , Toast.LENGTH_SHORT).show();
             // button1.clearAnimation();
                 button1.setVisibility(View.INVISIBLE);
            break;
            case R.id.button4:
                dial4.show(getFragmentManager(), "dlg4");
                Toast.makeText(getActivity(), "button 4" , Toast.LENGTH_SHORT).show();
                button4.setVisibility(View.INVISIBLE);
                break;
            case R.id.button2:
                button2.setVisibility(View.INVISIBLE);
                break;
            case R.id.button3:
                button3.setVisibility(View.INVISIBLE);
                break;
        }

    }
}