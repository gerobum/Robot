package com.example.maillot.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewPrenom;
    private TextView textViewTel;
    private TextView textViewTypeTel;
    private Button buttonModify;
    private Button buttonRegister;
    private Button buttonLoad;

    private ArrayList<Ligne> carnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewPrenom = (TextView) findViewById(R.id.textName);
        textViewTel = (TextView) findViewById(R.id.textPhone);
        textViewTypeTel = (TextView) findViewById(R.id.textTypeTel);
        buttonModify = (Button) findViewById(R.id.buttonModify);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonLoad = (Button) findViewById(R.id.buttonLoad);

        carnet = new ArrayList<>();

        buttonModify.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == buttonModify) {
            startActivity(new Intent(this, ModificationActivity.class));
        }
    }
}
