package am.itspace.car_rental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void goToRegistrationPage(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        Button backButton = findViewById(R.id.include);
        backButton.setOnClickListener(v -> {
            // Handle back button click here
            onBackPressed();
        });
    }
}
