package com.example.p1406544.ptut_android.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.p1406544.ptut_android.R;


public class Home_page extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void gocreaTp(View v){
        Intent intentcreaTP = new Intent(this, Select_groupe.class);
        startActivity(intentcreaTP);
    }

    public void gochargeTp(View v){

    }

    public void goManageGroup(View v){
        Intent intentManageGroup = new Intent(this, Manage_groupes.class);
        startActivity(intentManageGroup);
    }

    public void gocreatecomp(View v){
        Intent intentManageComp = new Intent(this, Manage_comp.class);
        startActivity(intentManageComp);

    }

    public void goquit(View v){
        AlertDialog.Builder quitter = new AlertDialog.Builder(this);
        quitter.setTitle("Quitter ?");
        quitter.setMessage("Souhaitez vous quitter l'application ?");
        quitter.setPositiveButton("Quitter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        quitter.setNegativeButton("Rester", null);
        quitter.show();
    }
}
