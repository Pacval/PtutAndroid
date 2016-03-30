package com.example.p1406544.ptut_android.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.p1406544.ptut_android.R;
import com.example.p1406544.ptut_android.adapters.Student_adapter;
import com.example.p1406544.ptut_android.models.Student;

import java.util.ArrayList;
import java.util.List;

public class View_students_groupe extends Activity {

    List<Student> studentList = new ArrayList<Student>();
    final Student_adapter student_adapter = new Student_adapter(this, studentList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students_groupe);

        Intent intent = getIntent();
        String groupe = intent.getStringExtra("nomGroupe");

        TextView tvnom = (TextView) findViewById(R.id.tvViewNomGroupe);
        tvnom.setText("Groupe : " + groupe);



        final ListView listView = (ListView) findViewById(R.id.listViewStudentsViewGroupe);
        listView.setAdapter(student_adapter);

        studentList.add(new Student("Rochet", "Valentin"));
        student_adapter.notifyDataSetChanged();
        studentList.add(new Student("Merle", "Jeremy"));
        student_adapter.notifyDataSetChanged();
        studentList.add(new Student("Blanc", "Maxime"));
        student_adapter.notifyDataSetChanged();



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder suppr = new AlertDialog.Builder(View_students_groupe.this);
                suppr.setTitle("Suppression");
                suppr.setMessage("Supprimer cet etudiant ?\n" + studentList.get(position).getNom() + " " + studentList.get(position).getPrenom());
                suppr.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        studentList.remove(position);
                        student_adapter.notifyDataSetChanged();
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
}
