package com.example.maillot.examen2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ModificationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName;
    private EditText editTextTel;
    private ListView listViewTypeTel;
    private Button okButton;
    private Button cancelButton;
    private String selected;
    private final String[] SELECTION = {"Portable", "Maison", "Bureau"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextTel = (EditText) findViewById(R.id.editTextPhone);
        listViewTypeTel = (ListView) findViewById(R.id.listView);
        listViewTypeTel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selected = SELECTION[i];
                adapterView.setSelection(i);
            }
        });
        editTextName.setText(getIntent().getStringExtra("Prenom"));
        editTextTel.setText(getIntent().getStringExtra("Tel"));

        selected = getIntent().getStringExtra("Type");
        selectItem();

        okButton = (Button) findViewById(R.id.buttonOK);
        cancelButton = (Button) findViewById(R.id.buttonAnnuler);

        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);


        ArrayAdapter<String> valeursMagiques = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, SELECTION);

        listViewTypeTel.setAdapter(valeursMagiques);
    }

    private void selectItem() {
        for(int i = 0; i < SELECTION.length; ++i) {
            if (SELECTION[i].equals(selected)) {
                listViewTypeTel.setSelection(i);
                Log.v("carnet", "Trouvé");
                return;
            }
        }
        Log.v("carnet", "Pas trouvé");
    }

    @Override
    public void onClick(View view) {
        if (view == okButton) {
            Intent result = new Intent();
            result.putExtra("Prenom", editTextName.getText().toString());
            result.putExtra("Tel", editTextTel.getText().toString());
            result.putExtra("Type", selected);
            setResult(RESULT_OK, result);
        } else {
            setResult(RESULT_CANCELED, null);
        }
        finish();
    }
}
