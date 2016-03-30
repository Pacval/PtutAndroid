package com.example.p1406544.ptut_android.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.p1406544.ptut_android.R;
import com.example.p1406544.ptut_android.adapters.Comp_adapter;
import com.example.p1406544.ptut_android.models.Competence;

import java.util.ArrayList;
import java.util.List;

public class Manage_comp extends Activity {

    List<Competence> competenceList = new ArrayList<>();
    Comp_adapter comp_adapter = new Comp_adapter(this, competenceList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_comp);

        final ListView listView = (ListView) findViewById(R.id.listviewcomp);
        listView.setAdapter(comp_adapter);

        competenceList.add(new Competence("Integer", "Savoir instancier et maitriser un int"));
        comp_adapter.notifyDataSetChanged();
        competenceList.add(new Competence("Char", "Savoir instancier et maitriser un char"));
        comp_adapter.notifyDataSetChanged();
        competenceList.add(new Competence("Tableau", "Savoir instancier et parcourir un tableau a 1 ou 2 dimensions"));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                final AlertDialog.Builder informations = new AlertDialog.Builder(Manage_comp.this);
                informations.setTitle(competenceList.get(position).getNom());
                informations.setMessage(competenceList.get(position).getDescription());
                informations.setPositiveButton("OK", null);
                informations.show();

            }
        });
    }

    public void goReturn(View v){
        finish();
    }
}
