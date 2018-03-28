package com.anaydeshpande.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tipTotalTextView;
    TextView totalTextView;
    EditText billTotalEditText;
    EditText tipTotalEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipTotalTextView = (TextView) findViewById(R.id.tipTotalTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        billTotalEditText = (EditText) findViewById(R.id.billTotalEditText);
        tipTotalEditText = (EditText) findViewById(R.id.tipTotalEditText);

        tipTotalEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                //Get billTotal
                Double billTotal = Double.valueOf(billTotalEditText.getText().toString());
                //Get tiptotal
                Double tipTotal = Double.valueOf(tipTotalEditText.getText().toString());
                //determine tip
                Double tip = (tipTotal / 100)* billTotal;
                //display tip
                tipTotalTextView.setText("Tip - $" + String.format("%.2f", tip));
                //Determine total
                Double total = billTotal + tip;
                //Display total
                totalTextView.setText("Total - $" + String.format("%.2f", total));
                return true;
            }
        });


    }
}
