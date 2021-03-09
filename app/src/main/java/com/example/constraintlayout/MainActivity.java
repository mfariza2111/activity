package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;

    EditText edemail, edpassword;

    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btSignIn);

        edemail=findViewById(R.id.edEmail);

        edpassword=findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                if(edemail.getText().toString().equals("admin@mail.com")&&edpassword.getText().toString().equals("123")) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "LOGIN SUKSES || email : " + nama + " password : " + password + "", Toast.LENGTH_LONG);
                    t.show(); // Jika aplikasi dijalankan dengan benar

                    //membuat objek
                    Bundle b = new Bundle();
                    // memasukan value dari variable dengan kunci "a"
                    // dan dimasukan kedalam Bunle
                    b.putString("a", nama.trim());
                    //membuat objek inten berpindah ke hasil
                    Intent i = new Intent(getApplicationContext(),  ActivityHasil.class);
                    //memasukkan bundle kedalam intent untuk dikirimkan ke ActivtyHasil
                    i.putExtras(b);
                    //berpindah ke activytyHasil
                    startActivity(i);
                }
                else{
                    Toast.makeText((getApplicationContext()), "Username atau Password Anda salah",
                            Toast.LENGTH_SHORT).show(); //  jika tidak benar maka akan muncul tampilan lain
                }
            }
        });
    }
}