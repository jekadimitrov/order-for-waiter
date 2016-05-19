package com.example.evgen.myrest;

import android.content.ClipData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by EVGEN on 26.04.2016.
 */
public class DialogADD extends DialogFragment {
   // implements OnClickListener

    Button btad, btcan;

    final String LOG_TAG = "myLogs";
    String[] zakaz1 = { "Вино", "Сок", "Шашлык", "Хлеб белый", "Вода без газов", "Картофель",
            "Икра красная", "Кофе_Лате", "чай черный", "Coca-Cola" };
    ArrayAdapter<String> adapter2;
    List<String> lisStr2;
    ListView List2;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialogadd, container, false);
        btad = (Button) v.findViewById(R.id.btnad);
        btcan = (Button) v.findViewById(R.id.btncan);
        List2 = (ListView) v.findViewById(R.id.li1);
      //  btad.setOnClickListener(this);
      //  btcan.setOnClickListener(this);

       /* btad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addItemList();
            }
        });*/

        List2.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        // Создаем адаптер, используя массив из файла ресурсов
        lisStr2 = new ArrayList<String>(Arrays.asList(zakaz1));
        adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, lisStr2);
        List2.setAdapter(adapter2);


        List2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                    SparseBooleanArray sbArray = List2.getCheckedItemPositions();
                    for (int i = 0; i < sbArray.size(); i++) {


                            int key = sbArray.keyAt(i);
                            if (sbArray.get(key))  Toast.makeText(getActivity(), "position = " + position, Toast.LENGTH_SHORT).show();
                            Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " );

                    }

            }
        });
        return v;
    }




    }





