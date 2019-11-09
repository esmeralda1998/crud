package com.example.crud;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout tiEmail, tiPassword;
    private EditText etEmail, etPassword;
    private Button btnLogin;

    View focusView = null;
    boolean estado_correo;
    boolean estado_password;

    Mantenimiento_Usuarios manto = new Mantenimiento_Usuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ///y esto para pantalla completa (oculta incluso la barra de estado)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        tiEmail = (TextInputLayout)findViewById(R.id.tiEmail);
        tiPassword = (TextInputLayout)findViewById(R.id.tiPassword);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnLogin:
                //Toast.makeText(this, "Vamos bien...", Toast.LENGTH_SHORT).show();
                login();
                break;

            default:

                break;
        }
    }


    private void login(){

        if (Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()== false) {
            //mEmail.setBackgroundColor(Color.GREEN);
            etEmail.setText(null);
            tiEmail.setError("Correo invalido.");
            focusView = etEmail;
            etEmail.requestFocus();
            estado_correo = false;
        }else {
            estado_correo = true;
            tiEmail.setError(null);
        }

        /*
        if (etPassword .getText().toString().isEmpty()){
        }*/

        if (estado_correo == true && (!etPassword.getText().toString().isEmpty())) {
            String correo = etEmail.getText().toString();
            String pass = etPassword.getText().toString();
            manto.verificarSesion(Login.this, correo, pass);
            limpiar();
        }

    }

    private void limpiar(){
        etEmail.setText(null);
        etPassword.setText(null);
        etEmail.requestFocus();
    }





}
