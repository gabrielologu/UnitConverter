package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView, textView1, textView2;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        textView = findViewById(R.id.resultView);
        textView1 = findViewById(R.id.titleUnitConverter);
        textView2 = findViewById(R.id.resultPounds);

        button = findViewById(R.id.convertBtn);

        editText = findViewById(R.id.inputKG);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = editText.getText().toString().trim();

                if (input.isEmpty()) {
                    editText.setError("This field cannot be blank");
                } else {
                    try {
                        fromKGtoPounds();
                    } catch (NumberFormatException e) { // in case the user inputs something like "21abc" instead of a valid number
                        editText.setError("Please input a valid number.");
                    }
                }
            }
        });



    }

    private void fromKGtoPounds() {
        String resultConverted = editText.getText().toString();
        double Kilo = Double.parseDouble(resultConverted);
        double pounds = Kilo * 2.205;
        textView2.setText("" + pounds);
    }
}