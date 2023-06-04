package am.itspace.car_rental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
    }

    public void submittingToast(View view) {
        Toast.makeText(RentActivity.this, "Car has been rented", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(RentActivity.this, MainActivity.class));
    }

    public void showCategories(View view) {
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
    }
}