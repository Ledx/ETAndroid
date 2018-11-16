package com.ledx.etandroid;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button ingresar = null;
    private TextInputLayout usuario = null;
    private TextInputLayout contra = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.Usuario);
        usuario.setErrorEnabled(true);
        contra = findViewById(R.id.Password);
        contra.setErrorEnabled(true);
        ingresar = findViewById(R.id.Ingresar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = usuario.getEditText().getText().toString();
                String c = contra.getEditText().getText().toString();

                if(!u.equals("") ){
                    usuario.setError(null);
                }else{
                    usuario.setError("Usuario es obligatorio");
                }
                if(!c.equals("") ){
                    contra.setError(null);
                }else{
                    contra.setError("Contrasena es obligatoria");
                }

                if(!u.equals("") && !c.equals("")) {
                    usuario.setError(null);
                    contra.setError(null);
                    Intent intent = new Intent(getApplicationContext(), InicioActivity.class);
                    intent.putExtra("Usuario", u);
                    startActivity(intent);
                }
            }
        });


    }
}
