package com.example.jdalv.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // method called when the button is clicked
    public void clickFunction(View view) {
        Log.i("Info", "Button pressed!"); // log the click in the Logcat

        EditText currencyEntered = (EditText) findViewById(R.id.currencyEditText); // declare input field

        String currency = currencyEntered.getText().toString(); // declare and initialize currency variable with input field value

        Log.i("Info", currencyEntered.getText().toString()); // log input field value to the Logcat

        double convertedCurrency = convertCurrency(Double.parseDouble(currency)); // call method to convert value (USD) to EUR

        Log.i("Info", "Converted currency: " + convertedCurrency); // log converted currency to the Logcat

        Toast.makeText(this, "Equals " + convertedCurrency + " EUR", Toast.LENGTH_LONG).show(); // show a toast with the converted currency value
    }

    // method that converts USD to Euros using multiplication
    public double convertCurrency(double USD) {
        double exchangeRate = 1.14; // current EUR to USD rate

        double convertedCurrency = USD * exchangeRate; // multiplies USD to Euros based on rate

        DecimalFormat currencyFormat = new DecimalFormat("#.##"); // declare a decimal format (0.00)

        double formattedCurrency = Double.parseDouble(currencyFormat.format(convertedCurrency)); // call format method and set variable to formatted value

        return formattedCurrency; // returns value back to clickFunction

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
