package com.example.p1406544.ptut_android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.p1406544.ptut_android.models.Binome;
import com.example.p1406544.ptut_android.adapters.Binome_adapter;
import com.example.p1406544.ptut_android.R;

import java.util.ArrayList;
import java.util.List;


public class Select_binome extends Activity {


    List<Binome> binomeList = new ArrayList<Binome>();
    final Binome_adapter binome_adapter = new Binome_adapter(this, binomeList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_binome);

        Intent intent = getIntent();
        String groupe = intent.getStringExtra("nomGroupe");
        TextView tvnomgroupe = (TextView) findViewById(R.id.selectBinomeGroupe);
        tvnomgroupe.setText("Groupe " + groupe);

        final ListView listView = (ListView) findViewById(R.id.listViewBinomes);
        listView.setAdapter(binome_adapter);

        binomeList.add(new Binome(1, "Etu A", "Etu B"));
        binome_adapter.notifyDataSetChanged();
        binomeList.add(new Binome(2, "Etu C", "Etu D"));
        binome_adapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intentReturn = new Intent();
                intentReturn.putExtra("numBinome", binomeList.get(position).getNumero());
                intentReturn.putExtra("nom1", binomeList.get(position).getNom1());
                intentReturn.putExtra("nom2", binomeList.get(position).getNom2());
                setResult(Activity.RESULT_OK, intentReturn);
                finish();
            }
        });
    }

}
