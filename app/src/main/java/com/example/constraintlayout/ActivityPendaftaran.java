package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ActivityPendaftaran extends AppCompatActivity {
    EditText edtNama, edtAlamat, edtEmail, edtPass, edtrePass;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        edtNama = findViewById(R.id.edNama);
        edtEmail = findViewById(R.id.edEmail);
        edtAlamat = findViewById(R.id.edAlamat);
        edtPass = findViewById(R.id.edPass);
        edtrePass = findViewById(R.id.ederPass);
        fab = findViewById(R.id.fabSimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNama.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtPass.getText().toString().isEmpty() ||
                        edtrePass.getText().toString().isEmpty())
                {
                    Snackbar.make(view, "Fill the blank data", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if (edtPass.getText().toString().equals(edtrePass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "registration is successful",
                                Toast.LENGTH_LONG).show();
                        Intent i =new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "password and repassword must be same",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}