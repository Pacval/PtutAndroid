package com.example.p1406544.ptut_android.adapters;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.p1406544.ptut_android.R;
import com.example.p1406544.ptut_android.models.Student;

import java.util.List;

public class Student_adapter extends BaseAdapter {

    private List<Student> studentList;
    private Activity activity;



    public Student_adapter(Activity activity, List<Student> listStudent){
        this.activity = activity;
        this.studentList = listStudent;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final Student student = studentList.get(position);

        LinearLayout layout;
        if(view == null) {
            layout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.item_student, null);
        } else {
            layout = (LinearLayout)view;
        }

        final TextView tvnom = (TextView) layout.findViewById(R.id.itemstudnom);
        final TextView tvprenom = (TextView) layout.findViewById(R.id.itemstudprenom);

        tvnom.setText(student.getNom());
        tvprenom.setText(student.getPrenom());

        return layout;
    }
}
