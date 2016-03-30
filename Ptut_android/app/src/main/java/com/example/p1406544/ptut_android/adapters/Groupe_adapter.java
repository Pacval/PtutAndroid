package com.example.p1406544.ptut_android.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.p1406544.ptut_android.R;
import com.example.p1406544.ptut_android.models.Groupe;

import java.util.List;

public class Groupe_adapter extends BaseAdapter {

    private List<Groupe> groupeList;
    private Activity activity;



    public Groupe_adapter(Activity activity, List<Groupe> listgroupe){
        this.activity = activity;
        this.groupeList = listgroupe;
    }

    @Override
    public int getCount() {
        return groupeList.size();
    }

    @Override
    public Object getItem(int position) {
        return groupeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final Groupe groupe = groupeList.get(position);

        LinearLayout layout;
        if(view == null) {
            layout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.item_groupe, null);
        } else {
            layout = (LinearLayout)view;
        }

        final TextView tvnumero = (TextView) layout.findViewById(R.id.tvgroupeNom);
        tvnumero.setText(groupe.getNom());


        return layout;
    }
}
