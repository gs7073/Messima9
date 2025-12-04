package com.example.messima9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String st = item.getTitle().toString();

        String s1 = et1.getText().toString().trim();
        String s2 = et2.getText().toString().trim();

        if (st.equals("C")) {
            et1.setText("");
            et2.setText("");
            tv1.setText("");
            return true;
        }

        if (s1.equals("") || s2.equals("")) {
            tv1.setText("Enter numbers");
            return true;
        }

        double n1, n2;

        try {
            n1 = Double.parseDouble(s1);
            n2 = Double.parseDouble(s2);
        } catch (NumberFormatException e) {
            tv1.setText("wrong input");
            return true;
        }

        double r;

        if (st.equals("+")) {
            r = n1 + n2;
            tv1.setText(String.valueOf(r));

        } else if (st.equals("-")) {
            r = n1 - n2;
            tv1.setText(String.valueOf(r));

        } else if (st.equals("*")) {
            r = n1 * n2;
            tv1.setText(String.valueOf(r));

        } else if (st.equals("/")) {

            if (n2 == 0) {
                tv1.setText("cant divide in 0");
                return true;
            }

            r = n1 / n2;
            tv1.setText(String.valueOf(r));

        }

        return true;
    }
}
