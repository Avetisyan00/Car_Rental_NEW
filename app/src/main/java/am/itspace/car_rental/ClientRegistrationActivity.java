package am.itspace.car_rental;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import am.itspace.car_rental.dto.RegistrationDto;
import am.itspace.car_rental.model.User;
import am.itspace.car_rental.retrofit.RetrofitService;
import am.itspace.car_rental.retrofit.UserApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_registration);

        Spinner staticSpinner = findViewById(R.id.static_spinner);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this, R.array.driver_licence_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);

        initializeComponents();
    }

    private void initializeComponents() {
        TextInputEditText nameField = findViewById(R.id.input_name);
        TextInputEditText surnameField = findViewById(R.id.input_surname);
        TextInputEditText ageField = findViewById(R.id.input_age);
        TextInputEditText emailField = findViewById(R.id.input_email);
        TextInputEditText phoneNumberField = findViewById(R.id.input_phone_number);
        TextInputEditText passwordField = findViewById(R.id.input_password);
        Button submitButton = findViewById(R.id.submit_button);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);
        submitButton.setOnClickListener(view -> {
            RegistrationDto registeredUser = new RegistrationDto();
            registeredUser.setName(nameField.toString());
            registeredUser.setSurname(surnameField.toString());
            registeredUser.setAge(Integer.parseInt(ageField.getText().toString()));
            registeredUser.setEmail(emailField.toString());
            registeredUser.setPhoneNumber(phoneNumberField.toString());
            registeredUser.setPassword(passwordField.toString());
            userApi.clientRegistration(registeredUser).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Toast.makeText(ClientRegistrationActivity.this, "Save Succeeded", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(ClientRegistrationActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}