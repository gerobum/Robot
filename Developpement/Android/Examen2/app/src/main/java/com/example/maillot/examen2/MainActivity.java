package com.example.maillot.examen2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    private final static int FROM_MODIFICATION = 0;

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
            Intent intent = new Intent(this, ModificationActivity.class);
            intent.putExtra("Prenom", textViewPrenom.getText().toString());
            intent.putExtra("Tel", textViewTel.getText().toString());
            intent.putExtra("Type", textViewTypeTel.getText().toString());
            startActivityForResult(intent, FROM_MODIFICATION);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v("carnet", "Retour " + requestCode + ", " + resultCode + ", " + data);

        if (requestCode == FROM_MODIFICATION && resultCode == RESULT_OK) {
            textViewPrenom.setText(data.getStringExtra("Prenom"));
            textViewTel.setText(data.getStringExtra("Tel"));
            textViewTypeTel.setText(data.getStringExtra("Type"));
        }
    }
}
