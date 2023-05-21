package com.example.letsconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Mass extends AppCompatActivity {
    public static final DecimalFormat df = new DecimalFormat("0.00");
    Spinner spinner_from;
    Spinner spinner_to;
    String from_value;
    String to_value;
    Button button;
    TextView textView;
    EditText editText;


    String[] mass_unit = {"kg", "g", "mg", "lb"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);



        spinner_from = findViewById(R.id.spinner_from);
        spinner_to = findViewById(R.id.spinner_to);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView6);
        editText = findViewById(R.id.editTextNumberDecimal3);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Mass.this, android.R.layout.simple_spinner_item,mass_unit);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(adapter);
        spinner_to.setAdapter(adapter);

        spinner_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from_value = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to_value = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(editText.getText().toString());
                double conv_num;
                if(from_value == to_value){
                    textView.setText(df.format(num) + " " + to_value);
                } else if (from_value == "kg" && to_value == "g") {
                    conv_num = num * 1000;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
                else if (from_value == "kg" && to_value == "mg") {
                    conv_num = num * 1000000;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }

                else if(from_value == "kg" && to_value == "lb"){
                    conv_num = num * 2.205;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
                else if(from_value == "g" && to_value == "kg"){
                    conv_num = num / 1000;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
                else if(from_value == "g" && to_value == "mg"){
                    conv_num = num * 1000;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
                else if(from_value == "g" && to_value == "lb"){
                    conv_num = num / 453.6;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
                else if(from_value == "mg" && to_value == "kg"){
                    conv_num = num / 1000000;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
                else if(from_value == "mg" && to_value == "g"){
                    conv_num = num / 1000;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
                else if(from_value == "mg" && to_value == "lb"){
                    conv_num = num / 453600;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
                else if(from_value == "lb" && to_value == "kg"){
                    conv_num = num / 2.205;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
                else if(from_value == "lb" && to_value == "g"){
                    conv_num = num * 453.6;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
                else if(from_value == "lb" && to_value == "mg"){
                    conv_num = num * 453600;
                    textView.setText(df.format(conv_num) + " " + to_value);
                }
            }
        });
    }


}