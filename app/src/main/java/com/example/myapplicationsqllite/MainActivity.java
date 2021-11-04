package com.example.myapplicationsqllite;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editTextRG;
    EditText editTextNome;
    EditText editTextEmail;
    EditText editTextRA;
    EditText editTextCurso;
    Button btnAdd;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextRG = findViewById(R.id.editTextRG);
        editTextNome = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextRA = findViewById(R.id.editTextRA);
        editTextCurso = findViewById(R.id.editTextCurso);
        btnAdd = findViewById((R.id.btn_add));
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        loadSpinnerData();
    }

    private void loadSpinnerData() {
        DatabaseHandler db = new
                DatabaseHandler(getApplicationContext());
        List<Aluno> labels = db.getAllLabels();
        // Creating adapter for spinner
        ArrayAdapter<Aluno> dataAdapter = new
                ArrayAdapter<Aluno>(this, android.R.layout.simple_spinner_item,
                labels);
        // Drop down layout style - list view with radio button

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    public void addAluno(View view) {
        Aluno aluno = new Aluno(editTextRG.getText().toString(),
                editTextNome.getText().toString(),
                editTextEmail.getText().toString(),
                editTextRA.getText().toString(),
                editTextCurso.getText().toString());
        if (aluno.getRg().trim().length() > 0) {
            DatabaseHandler db = new
                    DatabaseHandler(getApplicationContext());
            db.insertLabel(aluno);
            // making input filed text to blank
                    editTextNome.setText("");
                    editTextEmail.setText("");
                    editTextRA.setText("");
                    editTextCurso.setText("");
            // Hiding the keyboard
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editTextNome.getWindowToken(), 0);
            // loading spinner with newly added data
            loadSpinnerData();
        } else {
            Toast.makeText(getApplicationContext(), "Please enter label name",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String aluno = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + aluno,  Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // TODO Auto-generated method stub
    }
}