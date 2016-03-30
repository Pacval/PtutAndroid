package com.example.p1406544.ptut_android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.p1406544.ptut_android.R;
import com.example.p1406544.ptut_android.adapters.Groupe_adapter;
import com.example.p1406544.ptut_android.models.Groupe;

import java.util.ArrayList;
import java.util.List;

public class Select_groupe extends Activity {

    List<Groupe> groupeList = new ArrayList<Groupe>();
    final Groupe_adapter groupe_adapter = new Groupe_adapter(this, groupeList);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_groupe);

        final ListView listView = (ListView) findViewById(R.id.selectGroupeListviewgroupes);
        listView.setAdapter(groupe_adapter);

        groupeList.add(new Groupe("G2S4"));
        groupe_adapter.notifyDataSetChanged();
        groupeList.add(new Groupe("G1S2"));
        groupe_adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(v.getContext(), Create_tp.class);
                intent.putExtra("nomGroupe", groupeList.get(position).getNom());
                startActivity(intent);
            }
        });

    }

    public void goReturn(View v){
        finish();
    }
}
