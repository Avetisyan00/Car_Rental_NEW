package am.itspace.car_rental;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CategoriesActivity extends AppCompatActivity {

    String[] options = {"limo", "cargo", "jeep", "sport"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_dropdown);
        autoCompleteTextView = findViewById(R.id.dropdownAutoCompleteTextView);
        adapter = new ArrayAdapter<String>(this, R.layout.category_dropdown, options);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String option = parent.getItemAtPosition(position).toString();
                Toast.makeText(CategoriesActivity.this, "option is " + option, Toast.LENGTH_SHORT).show();
            }
        });
    }
}