package com.example.p1406544.ptut_android.adapters;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.p1406544.ptut_android.R;
import com.example.p1406544.ptut_android.activities.Manage_comp;
import com.example.p1406544.ptut_android.models.Competence;
import com.example.p1406544.ptut_android.models.Student;

import java.util.ArrayList;
import java.util.List;

public class Comp_adapter extends BaseAdapter{

    private List<Competence> competenceList = new ArrayList<>();
    private Activity activity;

    public Comp_adapter(Activity activity, List<Competence> listComp) {
        this.activity = activity;
        this.competenceList = listComp;
    }


    @Override
    public int getCount() {
        return competenceList.size();
    }

    @Override
    public Object getItem(int position) {
        return competenceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final Competence competence = competenceList.get(position);

        LinearLayout layout;
        if(view == null) {
            layout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.item_comp, null);
        } else {
            layout = (LinearLayout)view;
        }

        final TextView tvnom = (TextView) layout.findViewById(R.id.itemcompNom);
        tvnom.setText(competence.getNom());


        return layout;
    }
}
