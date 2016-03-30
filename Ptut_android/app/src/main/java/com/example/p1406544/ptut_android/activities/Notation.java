package com.example.p1406544.ptut_android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.p1406544.ptut_android.R;


public class Notation extends Activity {

    private static final int REQUESTCODEGROUPES = 1;
    int exnum = 0, num = 0;
    String groupe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notation);

        Intent intent = getIntent();

        groupe = intent.getStringExtra("nomGroupe");

        String titre = intent.getStringExtra("titreTP");
        TextView textv = (TextView) findViewById(R.id.titreTP);
        textv.setText("Titre du TP : " + titre);

        int noteMax = intent.getIntExtra("noteMax", 20);
        TextView textv2 = (TextView) findViewById(R.id.noteMax);
        textv2.setText("/ " + noteMax);
    }

    public void goGroupes(View v){
        Intent intent = new Intent(this, Select_binome.class);
        intent.putExtra("nomGroupe", groupe);
        startActivityForResult(intent, REQUESTCODEGROUPES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUESTCODEGROUPES) {
            if(resultCode == Activity.RESULT_OK){
                num = data.getIntExtra("numBinome", 0);

                if (exnum != num) {
                    String nom1 = data.getStringExtra("nom1");
                    String nom2 = data.getStringExtra("nom2");

                    TextView tvnom1 = (TextView) findViewById(R.id.tvNotationNom1);
                    tvnom1.setText("Nom : " + nom1);

                    TextView tvnom2 = (TextView) findViewById(R.id.tvNotationNom2);
                    tvnom2.setText("Nom : " + nom2);

                    EditText et1 = (EditText) findViewById(R.id.edittextcomment1);
                    et1.setText("");

                    EditText et2 = (EditText) findViewById(R.id.edittextcomment2);
                    et2.setText("");
                }

                exnum = num;
            }

        }
    }

}
