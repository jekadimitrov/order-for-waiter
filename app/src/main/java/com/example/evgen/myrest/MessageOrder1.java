package com.example.evgen.myrest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by EVGEN on 25.04.2016.
 */
public class MessageOrder1  extends Fragment implements OnClickListener {

    DialogFragment dlg2;
    final String LOG_TAG = "myLogs";
    Button btitem, btorder;
    ListView List1;
   String[] zakaz = { "Вино", "Сок", "Шашлык", "Хлеб белый", "Вода без газов", "Картофель",
            "Икра красная", "Кофе_Лате", "чай черный", "Coca-Cola" };
    ArrayAdapter<String> adapter1;

    List<String> lisStr;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_order1, container, false);



        btitem = (Button) v.findViewById(R.id.bitem);
        btorder = (Button) v.findViewById(R.id.border);
        List1 = (ListView) v.findViewById(R.id.list1);
        btitem.setOnClickListener(this);
        btorder.setOnClickListener(this);
        lisStr = new ArrayList<String>(Arrays.asList(zakaz));
        adapter1 = new ArrayAdapter<String>(getActivity(), R.layout.list_row, lisStr);
        List1.setAdapter(adapter1);



        List1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long arg3) {
                removeItemFromList(position);

                return true;
            }
        });
        dlg2 = new DialogADD();
        return v;
    }
    // method to remove list item
    protected void removeItemFromList(int position) {
        final int deletePosition = position;

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        alert.setTitle("Delete");
        alert.setMessage("Do you want delete this item?");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TOD O Auto-generated method stub

                // main code on after clicking yes
                lisStr.remove(deletePosition);
                adapter1.notifyDataSetChanged();
                adapter1.notifyDataSetInvalidated();

            }
        });
        alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        alert.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bitem:
                dlg2.show(getFragmentManager(), "dlg1");
            break;
            case R.id.border:
                Intent intent = new Intent(getContext(), NewTest.class);
                startActivity(intent);
                break;
        }
    }




}