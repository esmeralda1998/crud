package com.example.crud;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

public class activity_consulta_recycler_View extends AppCompatActivity {

    RecyclerView recyclerView;

    ProductsAdapter adapter;

    //MantenimientoMySQL manto = new MantenimientoMySQL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta__recycler_view1);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adapter = new ProductsAdapter(activity_consulta__recycler_view1.this, manto.consultarAllArticulos(getApplicationContext()));
        //recyclerView.setAdapter(adapter);


    }
}
