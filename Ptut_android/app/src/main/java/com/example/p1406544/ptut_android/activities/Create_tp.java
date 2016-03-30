package com.example.p1406544.ptut_android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.p1406544.ptut_android.models.Exercice;
import com.example.p1406544.ptut_android.adapters.Exercice_adapter;
import com.example.p1406544.ptut_android.R;

import java.util.ArrayList;
import java.util.List;


public class Create_tp extends Activity {

    List<Exercice> exerciceList = new ArrayList<Exercice>();
    final Exercice_adapter exercice_adapter = new Exercice_adapter(this, exerciceList);
    String groupe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tp);

        Intent intent = getIntent();
        groupe = intent.getStringExtra("nomGroupe");

        final ListView listView = (ListView)findViewById(R.id.listViewExos);
        listView.setAdapter(exercice_adapter);

        Button buttonAdd = (Button)findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exerciceList.add(new Exercice("0", "", "", ""));
                exercice_adapter.notifyDataSetChanged();
            }
        });
    }



    public void goNotation(View v){
        Intent intent = new Intent(this, Notation.class);

        intent.putExtra("nomGroupe", groupe);

        EditText editText = (EditText) findViewById(R.id.editTextTitreTP);
        String titre = editText.getText().toString();
        intent.putExtra("titreTP", titre);

        int noteMax = 0;
        Exercice exo;
        for (int i = 0 ; i < exercice_adapter.getCount() ; i++){
            exo = (Exercice) exercice_adapter.getItem(i);
            noteMax += Integer.parseInt(exo.getNote());
        }
        intent.putExtra("noteMax", noteMax);

        startActivity(intent);
    }
}
