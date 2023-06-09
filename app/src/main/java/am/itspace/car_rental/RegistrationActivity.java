package am.itspace.car_rental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_selection);
    }

    public void goToClientRegistrationPage(View view) {
        Intent intent = new Intent(this, ClientRegistrationActivity.class);
        startActivity(intent);
    }

    public void goToDriverRegistrationPage(View view) {
        Intent intent = new Intent(this, DriverRegistrationActivity.class);
        startActivity(intent);
    }
}