package com.example.p1406544.ptut_android.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.p1406544.ptut_android.R;
import com.example.p1406544.ptut_android.models.Binome;

import java.util.List;

public class Binome_adapter extends BaseAdapter {

    private List<Binome> binomeList;
    private Activity activity;


    public Binome_adapter(Activity activity, List<Binome> listBinome){
        this.activity = activity;
        this.binomeList = listBinome;
    }

    @Override
    public int getCount() {
        return binomeList.size();
    }

    @Override
    public Object getItem(int position) {
        return binomeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final Binome binome = binomeList.get(position);

        LinearLayout layout;
        if(view == null) {
            layout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.item_binome, null);
        } else {
            layout = (LinearLayout)view;
        }

        final TextView tvnumero = (TextView) layout.findViewById(R.id.tvNumBinome);
        final TextView tvnom1 = (TextView) layout.findViewById(R.id.tvnom1);
        final TextView tvnom2 = (TextView) layout.findViewById(R.id.tvnom2);

        tvnumero.setText("" + binome.getNumero());
        tvnom1.setText(binome.getNom1());
        tvnom2.setText(binome.getNom2());

        return layout;
    }
}