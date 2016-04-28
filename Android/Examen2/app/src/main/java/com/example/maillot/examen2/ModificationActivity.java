package com.example.maillot.examen2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ModificationActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextTel;
    private ListView listViewTypeTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextTel = (EditText) findViewById(R.id.editTextPhone);
        listViewTypeTel = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> valeursMagiques = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[] {"Portable", "Maison", "Bureau"});

        listViewTypeTel.setAdapter(valeursMagiques);
    }
}
