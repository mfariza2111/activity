package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;


import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ListView list;
    private ListViewAdapter Adapter;
    String[] listnama;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();

    Intent intent;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listnama = new String[]{"Selma", "Putri", "Chika", "Alifhia", "Selmatiranika", "Ristina", "DevharaDhea", "Rika", "Medi", "Tono"};

        list = findViewById(R.id.listKontak);

        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listnama.length; i++) {
            ClassNama classNama = new ClassNama(listnama[i]);

            classNamaArrayList.add(classNama);

             Adapter = new ListViewAdapter(this);

            list.setAdapter(Adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String nama = classNamaArrayList.get(position).getName();

                    bundle.putString("a", nama.trim());

                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                    pm.setOnMenuItemClickListener(Home_Activity.this);

                    pm.inflate(R.menu.popupp_menuu);

                    pm.show();

                }
            });

        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"ini untuk edit kontak", Toast.LENGTH_LONG).show();
                break;

        }
        return false;
    }
}