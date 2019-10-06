package com.example.relocationmovingtruck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int intSize;
    float decMiles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText size = (EditText)findViewById(R.id.txtTruck);
        final EditText miles = (EditText)findViewById(R.id.txtMiles);
        Button button = (Button)findViewById(R.id.btnCost);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decMiles = Float.parseFloat(miles.getText().toString());
                intSize = Integer.parseInt(size.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", decMiles);
                editor.putInt("key2", intSize);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });
    }
}
