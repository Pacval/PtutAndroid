package com.example.p1406544.ptut_android.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.p1406544.ptut_android.R;
import com.example.p1406544.ptut_android.adapters.Groupe_adapter;
import com.example.p1406544.ptut_android.models.Groupe;

import java.util.ArrayList;
import java.util.List;


public class Manage_groupes extends Activity {

    List<Groupe> groupeList = new ArrayList<Groupe>();
    final Groupe_adapter groupe_adapter = new Groupe_adapter(this, groupeList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_groupes);

        final ListView listView = (ListView) findViewById(R.id.manageGroupListviewgroupes);
        listView.setAdapter(groupe_adapter);

        groupeList.add(new Groupe("G2S4"));
        groupe_adapter.notifyDataSetChanged();
        groupeList.add(new Groupe("G1S2"));
        groupe_adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(v.getContext(), View_students_groupe.class);
                intent.putExtra("nomGroupe", groupeList.get(position).getNom());
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder suppr = new AlertDialog.Builder(Manage_groupes.this);
                suppr.setTitle("Suppression");
                suppr.setMessage("Supprimer ce groupe ?\n" + groupeList.get(position).getNom());
                suppr.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        groupeList.remove(position);
                        groupe_adapter.notifyDataSetChanged();
                    }
                });
                suppr.setNegativeButton("Non", null);
                suppr.show();

                return true;
            }
        });
    }

    public void goReturn(View v){
        finish();
    }

    public void addGroupe(View v){
        EditText etNomGroupe = (EditText) findViewById(R.id.etgrpNomGroupe);
        groupeList.add(new Groupe(etNomGroupe.getText().toString()));
        groupe_adapter.notifyDataSetChanged();
    }
}
