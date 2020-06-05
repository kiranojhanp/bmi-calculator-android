package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get instances of widgets
        final EditText weight = (EditText) findViewById(R.id.editTextweight);
        final EditText height = (EditText) findViewById(R.id.editTextheight);
        final TextView result = (TextView) findViewById(R.id.textView3);

        findViewById(R.id.buttonclc).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String wt = weight.getText().toString();
                String ht = height.getText().toString();

                // validation
                if (TextUtils.isEmpty(wt)){
                    weight.setError("Please enter your weight");
                    weight.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(ht)){
                    height.setError("Please enter your weight");
                    height.requestFocus();
                    return;
                }

                // Get the user values and parse them to float
                float high = Float.parseFloat(ht);
                float weigh = Float.parseFloat(wt);

                // Calculate BMI
                float bmiValue = calculateBMI(weigh, high);
                String bmiInterpretation = interpretBMI(bmiValue);

                result.setText(String.valueOf("BMI: " + bmiValue + "\n" + bmiInterpretation));

            }
        });
    }

    // Calculate BMI
    private float calculateBMI(float weight, float height){
        return (float) (weight / (height * height));
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue){
        String output = "";
        if (bmiValue < 18.5){
            output =  "Underweight";
        }
        else if(bmiValue < 24.9){
            output = "Healthy weight";
        }
        else if(bmiValue < 29.9){
            output = "Over weight";
        }
        else {
            output = "extremely obese";
        }
        return output;
    }
}
