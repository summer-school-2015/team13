package com.example.Prob;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class MyActivity extends Activity implements View.OnClickListener {

    static int sum = 0;
    static Button button1;
    static Button button2;
    static Button button3;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    public boolean is_prime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void onClick(View v) {

        if (v instanceof Button) {
            Button button = (Button) v;

            int clicks = Integer.parseInt(button.getText().toString());
            clicks++;
            sum++;

            button.setText(String.valueOf(clicks));

            if (is_prime(sum)) {
                button1.setBackgroundColor(Color.RED);
                button2.setBackgroundColor(Color.RED);
                button3.setBackgroundColor(Color.RED);
            } else {
                button1.setBackgroundColor(Color.GREEN);
                button2.setBackgroundColor(Color.GREEN);
                button3.setBackgroundColor(Color.GREEN);
            }
        }
    }
}