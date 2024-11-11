package com.stem.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvdisplay;
    EditText et,et2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvdisplay = findViewById(R.id.tvdisplay);
        et = findViewById(R.id.et);
        et2 = findViewById(R.id.et2);
        btn = findViewById(R.id.btn);


        btn.setOnClickListener(view -> {
           String buypriseInput = et.getText().toString().trim();
           String sellpriseInput = et2.getText().toString().trim();

           if (buypriseInput.isEmpty() || sellpriseInput.isEmpty()){
               tvdisplay.setText("Please enter both Buy Price and Sell Price.");
               return;
           }

            Float buyprise, sellprise, profit, profitpersent;
            buyprise = Float.parseFloat(buypriseInput);
            sellprise = Float.parseFloat(sellpriseInput);
            profit = sellprise - buyprise;
            profitpersent = profit / sellprise * 100;

            if (sellprise > buyprise) {
                tvdisplay.setText(String.valueOf("Profit is= " + profit + "\n Profit % is = " + profitpersent+"%"));
            } else if (buyprise.equals(sellprise)) {
                tvdisplay.setText("no profit no loss");
            } else {
                tvdisplay.setText(String.valueOf("Loss is= " + (-profit) + "\n Loss % is = " + (-profitpersent+"%")));
            }
        });






    }
}