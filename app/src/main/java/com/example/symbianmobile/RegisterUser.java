package com.example.symbianmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.symbianmobile.model.User;
import com.example.symbianmobile.remote.APIUtil;
import com.example.symbianmobile.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUser extends AppCompatActivity {

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        final EditText txtFirstName = findViewById(R.id.et_firstName);
        final EditText txtLastName = findViewById(R.id.et_lastName);
        final EditText txtEmail = findViewById(R.id.et_email);
        final EditText txtPhoneNumber = findViewById(R.id.et_phoneNumber);
        final Button btnRegister = findViewById(R.id.btn_register);
        routerInterface = APIUtil.getUserInterface();

        btnRegister.setOnClickListener(view -> {

            if (TextUtils.isEmpty(txtFirstName.getText().toString())) {
                txtFirstName.setError("Insert your first name");
                Toast.makeText(this, "All fields are necessary", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(txtLastName.getText().toString())) {
                txtLastName.setError("Insert your last name");
                Toast.makeText(this, "All fields are necessary", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(txtEmail.getText().toString())) {
                txtEmail.setError("Insert your email");
                Toast.makeText(this, "All fields are necessary", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(txtPhoneNumber.getText().toString())) {
                txtPhoneNumber.setError("Insert your phone number");
                Toast.makeText(this, "All fields are necessary", Toast.LENGTH_SHORT).show();
                return;
            }

            User user = new User();

            user.setFirstName(txtFirstName.getText().toString());
            user.setLastName(txtLastName.getText().toString());
            user.setEmail(txtEmail.getText().toString());
            user.setPhoneNumber(txtPhoneNumber.getText().toString());

            addUser(user);

        });
    }

    public void addUser(User user) {

        Call<User> call = routerInterface.addUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(RegisterUser.this, "Success!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("ERRO-API", t.getMessage());
            }
        });

    }

}