package com.example.p1406544.ptut_android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.p1406544.ptut_android.R;

import java.util.ArrayList;
import java.util.List;

public class Ajout_competences_exo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_competences_exo);

        TextView tvNom = (TextView) findViewById(R.id.compNomExo);
        tvNom.setText("Nom de l'exercice : " + getIntent().getStringExtra("nomExo"));

        List<String> compList = new ArrayList<>();
        compList.add("variable int");
        compList.add("variable char");
        compList.add("tableaux");


        LinearLayout compLayout = (LinearLayout) findViewById(R.id.layoutCheckboxCompetences);

        for(String comp : compList){
            CheckBox boxComp = new CheckBox(this);
            boxComp.setText(comp);
            compLayout.addView(boxComp);
        }
    }

    public void annuler(View v){
        finish();
    }

    public void valider(View v){
        finish();
    }
}