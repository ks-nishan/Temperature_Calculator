package com.example.temperaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onResume() {
        super.onResume();
        Button btnCalculate = (Button) findViewById(R.id.buttonCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {

        EditText editText = (EditText) findViewById(R.id.editTextUser);
        String userInput = editText.getText().toString();

        if( userInput.isEmpty()){
            Toast.makeText(this, "Please add a value", Toast.LENGTH_SHORT).show();
        }
        else{
            RadioButton radioButtonCelcius = (RadioButton) findViewById(R.id.radioButtonCelcius);
            Calculation calculations = new Calculation();
            TextView converter = (TextView) findViewById(R.id.textViewConverter);

            Float temp = Float.parseFloat(userInput);

            if( radioButtonCelcius.isChecked() ){
// convert it into Fahrenheit and display the answer
               float c =  calculations.convertFahrenheitToCelcius(temp);
                Toast.makeText(this, "converted "+c, Toast.LENGTH_SHORT).show();
                String myCel = Float.toString(c);
                converter.setText(myCel);
            }
            else{
// convert it into Celcius and display the answer
               float f = calculations.convertCelciusToFahrenheit(temp);
                Toast.makeText(this, "converted "+f, Toast.LENGTH_SHORT).show();
                String myFar = Float.toString(f);
                converter.setText(myFar);
            }
        }
    }
}