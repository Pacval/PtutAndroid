package com.example.p1406544.ptut_android.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.p1406544.ptut_android.R;
import com.example.p1406544.ptut_android.activities.Ajout_competences_exo;
import com.example.p1406544.ptut_android.activities.Create_tp;
import com.example.p1406544.ptut_android.models.Exercice;

import java.util.List;

public class Exercice_adapter extends BaseAdapter {

    private List<Exercice> listExo;
    private Activity activity;


    public Exercice_adapter(Activity activity, List<Exercice> listExo){
        this.activity = activity;
        this.listExo = listExo;
    }

    @Override
    public int getCount() {
        return listExo.size();
    }

    @Override
    public Object getItem(int position) {
        return listExo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final Exercice exercice = listExo.get(position);

        LinearLayout layout;
        if(view == null) {
            layout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.item_exo, null);
        } else {
            layout = (LinearLayout)view;
        }

        final EditText editTextNote = (EditText) layout.findViewById(R.id.editTextNote);
        final EditText editTextNom = (EditText) layout.findViewById(R.id.editTextNom);
        final EditText editTextDifficulte = (EditText) layout.findViewById(R.id.editTextDificulte);

        Button btComp = (Button) layout.findViewById(R.id.exoBtComp);

        editTextNote.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    exercice.setNote(editTextNote.getText().toString());
                }
            }
        });

        editTextNom.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    exercice.setNom(editTextNom.getText().toString());
                }
            }
        });

        editTextDifficulte.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    exercice.setDifficulte(editTextDifficulte.getText().toString());
                }
            }
        });

        btComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentComp = new Intent(v.getContext(), Ajout_competences_exo.class);
                String nomExo = exercice.getNom();
                intentComp.putExtra("nomExo", nomExo);

                activity.startActivity(intentComp);
            }
        });

        return layout;
    }


}