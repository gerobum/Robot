package gero.developpement.fr.carremagique;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText[][] value;
    private Button changeMagicButton;
    private Button remodeValueButton;
    private Button loadButton;
    private Button saveButton;
    private Button fillButton;
    private Button okButton;
    private int magicNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value = new EditText[3][3];

        value[0][0] = (EditText) findViewById(R.id.editText00);
        value[0][1] = (EditText) findViewById(R.id.editText01);
        value[0][2] = (EditText) findViewById(R.id.editText02);
        value[1][0] = (EditText) findViewById(R.id.editText10);
        value[1][1] = (EditText) findViewById(R.id.editText11);
        value[1][2] = (EditText) findViewById(R.id.editText12);
        value[2][0] = (EditText) findViewById(R.id.editText20);
        value[2][1] = (EditText) findViewById(R.id.editText21);
        value[2][2] = (EditText) findViewById(R.id.editText22);

        changeMagicButton = (Button) findViewById(R.id.magicButton);
        remodeValueButton = (Button) findViewById(R.id.deleteValueButton);
        loadButton = (Button) findViewById(R.id.loadButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        fillButton = (Button) findViewById(R.id.fillButton);
        okButton = (Button) findViewById(R.id.okButton);

        

        magicNumber = 15;

    }
}
