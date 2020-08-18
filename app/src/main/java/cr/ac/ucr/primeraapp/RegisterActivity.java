package cr.ac.ucr.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etEmail;
    private EditText etPassword;
    private EditText etName;
    private EditText etLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etName = findViewById(R.id.et_name);
        etLastName = findViewById(R.id.et_last_name);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                register();
                break;
            case R.id.btn_goto_login:
                gotoLogin();
                break;
            default:
                break;
        }
    }

    private void register() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();

        if(email.isEmpty()){
            etEmail.setError(getString(R.string.error_email));
            return;
        }
        if(password.isEmpty()){
            etPassword.setError(getString(R.string.error_password));
            return;
        }
        if(name.isEmpty()){
            etName.setError(getString(R.string.error_name));
            return;
        }
        if(lastName.isEmpty()){
            etLastName.setError(getString(R.string.error_last_name));
            return;
        }

        Toast.makeText(this, R.string.logged_in, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void gotoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}