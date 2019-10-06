package com.example.relocationmovingtruck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView interest = (TextView)findViewById(R.id.txtPayment);
        ImageView image = (ImageView)findViewById(R.id.imgTrucks);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float decMiles = sharedPref.getFloat("key1", 0);
        int intSize = sharedPref.getInt("key2", 0);

        double decPayment;
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        if (intSize == 10) {
            image.setImageResource(R.drawable.smalltruck);
            decPayment = (19.95 + (0.99 * decMiles));
            interest.setText("Total Cost: " + currency.format(decPayment));
        } else if (intSize == 17) {
            image.setImageResource(R.drawable.mediumtruck);
            decPayment = (29.95 + (0.99 * decMiles));
            interest.setText("Total Cost: " + currency.format(decPayment));
        } else if (intSize == 26) {
            image.setImageResource(R.drawable.bigtruck);
            decPayment = (39.95 + (0.99 * decMiles));
            interest.setText("Total Cost: " + currency.format(decPayment));
        } else {
            interest.setText("Enter 10, 17 or 26");
        }





    }
}
