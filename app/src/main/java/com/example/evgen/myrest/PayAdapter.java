package com.example.evgen.myrest;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by EVGEN on 26.04.2016.
 */
public class PayAdapter extends ArrayAdapter<Payment> {

    protected static final String LOG_TAG = PayAdapter.class.getSimpleName();

    private List<Payment> items;
    private int layoutResourceId;
    private Context context;

    public static class PaymentHolder {
        Payment paym;
        TextView name;
        TextView value;
        ImageButton removePaymentButton;
    }

    public PayAdapter(Context context, int layoutResourceId, List<Payment> items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PaymentHolder holder = null;

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        holder = new PaymentHolder();
        holder.paym = items.get(position);
        holder.removePaymentButton = (ImageButton)row.findViewById(R.id.removePay);
        holder.removePaymentButton.setTag(holder.paym);

        holder.name = (TextView)row.findViewById(R.id.Pay_name);
        setNameTextChangeListener(holder);
        holder.value = (TextView)row.findViewById(R.id.Pay_value);
        setValueTextListeners(holder);

        row.setTag(holder);

        setupItem(holder);
        return row;
    }

    private void setupItem(PaymentHolder holder) {
        holder.name.setText(holder.paym.getName());
        holder.value.setText(String.valueOf(holder.paym.getValue()));
    }



    private void setNameTextChangeListener(final PaymentHolder holder) {
        holder.name.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                holder.paym.setName(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void setValueTextListeners(final PaymentHolder holder) {
        holder.value.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    holder.paym.setValue(Double.parseDouble(s.toString()));
                }catch (NumberFormatException e) {
                    Log.e(LOG_TAG, "error reading double value: " + s.toString());
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }
}