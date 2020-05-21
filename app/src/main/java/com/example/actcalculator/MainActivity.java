package com.example.actcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean point = false;
    private String number = "";
    private String lastOperation = "=";
    private Double result = 0.0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void operationClick(View view) {
        Button button = (Button) view;
        String op = button.getText().toString();
        number = number.replace(",", ".");
        try {
            performOperators(Double.valueOf(number), op);

        } catch (NumberFormatException ex) {
            textView.setText("");
        }
        lastOperation = op;
    }

    public void performOperators(Double num, String op) {
        if (result == 0.0) {
            result = num;
        } else {
            if (lastOperation.equals("=")) {
                lastOperation = op;
            }
        }
        switch (lastOperation) {
            case "=":
                result = num;
                break;
            case "+":
                result += num;
                break;
            case "-":
                result -= num;
                break;
            case "/":
                if (num == 0) {
                    result = 0.0;
                } else {
                    result /= num;
                }
                break;
            case "x":
                result *= num;
                break;
        }
        textView.setText("");
        String outResult = result.toString();
        if (outResult.equals("0.0")) {
            outResult = "0";
        }
        textView.setHint(outResult.replace(".", ","));
        Toast.makeText(MainActivity.this, outResult, Toast.LENGTH_LONG).show();
    }

    public void numberClick(View view) {
        Button button = (Button) view;
        number = textView.getText().toString();
        if (number.length() == 0) {
            if (button.getText().equals(",")) {
                point = true;
                textView.append("0");
                textView.append(button.getText());
            }
        }
        if (button.getText().equals(",")) {
            if (!point) {
                point = true;
                textView.append(button.getText());
            }
        } else {
            if (number.length() == 0 && button.getText().equals("0")) {
                textView.setText("");
            } else {
                textView.append(button.getText());
                number = textView.getText().toString();
            }
        }
    }

    public void signChange(View view) {
        number = number.replace(",", ".");
        double signValue = Double.parseDouble(number);
        signValue = -1 * signValue;
        number = Double.toString(signValue);
        number = number.replace(".", ",");
        Toast.makeText(MainActivity.this, number, Toast.LENGTH_LONG).show();
        textView.setText(number);
    }

    public void clearClick(View view) {
        point = false;
        result = 0.0;
        number = "";
        textView.setText("");
        textView.setHint("0");

    }

    public void percentClick(View view) {
        number = number.replace(",", ".");
        double percentValue = Double.parseDouble(number);
        percentValue = percentValue / 100;
        number = Double.toString(percentValue);
        number = number.replace(".", ",");
        Toast.makeText(MainActivity.this, number, Toast.LENGTH_LONG).show();
        textView.setText(number);
    }

    private void initView() {
        textView = findViewById(R.id.textView);
        Button clearBtn = findViewById(R.id.clearBtn);
        Button symbolBtn = findViewById(R.id.symbolBtn);
        Button percentBtn = findViewById(R.id.percentBtn);
        Button divBtn = findViewById(R.id.divBtn);
        Button multiBtn = findViewById(R.id.multiBtn);
        Button minusBtn = findViewById(R.id.minusBtn);
        Button plusBtn = findViewById(R.id.plusBtn);
        Button equalBtn = findViewById(R.id.equalBtn);
        Button numberBtn_0 = findViewById(R.id.numberBtn_0);
        Button numberBtn_1 = findViewById(R.id.numberBtn_1);
        Button numberBtn_2 = findViewById(R.id.numberBtn_2);
        Button numberBtn_3 = findViewById(R.id.numberBtn_3);
        Button numberBtn_4 = findViewById(R.id.numberBtn_4);
        Button numberBtn_5 = findViewById(R.id.numberBtn_5);
        Button numberBtn_6 = findViewById(R.id.numberBtn_6);
        Button numberBtn_7 = findViewById(R.id.numberBtn_7);
        Button numberBtn_8 = findViewById(R.id.numberBtn_8);
        Button numberBtn_9 = findViewById(R.id.numberBtn_9);
        Button pointBtn = findViewById(R.id.pointBtn);
        clearBtn.setText(R.string.clearBtn);
        symbolBtn.setText(R.string.symbolBtn);
        percentBtn.setText(R.string.percentBtn);
        divBtn.setText(R.string.divBtn);
        multiBtn.setText(R.string.multiBtn);
        minusBtn.setText(R.string.minusBtn);
        plusBtn.setText(R.string.plusBtn);
        equalBtn.setText(R.string.equalBtn);
        numberBtn_0.setText(R.string.numberBtn_0);
        numberBtn_1.setText(R.string.numberBtn_1);
        numberBtn_2.setText(R.string.numberBtn_2);
        numberBtn_3.setText(R.string.numberBtn_3);
        numberBtn_4.setText(R.string.numberBtn_4);
        numberBtn_5.setText(R.string.numberBtn_5);
        numberBtn_6.setText(R.string.numberBtn_6);
        numberBtn_7.setText(R.string.numberBtn_7);
        numberBtn_8.setText(R.string.numberBtn_8);
        numberBtn_9.setText(R.string.numberBtn_9);
        pointBtn.setText(R.string.pointBtn);
    }
}
