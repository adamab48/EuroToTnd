package com.example.eurototnd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eurototnd.R;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private EditText editTextAmount;
    private TextView textViewResult;
    private ListView listViewHistory;
    private ArrayList<String> conversionHistory;
    private ArrayAdapter<String> historyAdapter;
    private double exchangeRate = 3.1; // Taux de change euro-dinar


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        textViewResult = findViewById(R.id.textViewResult);
        listViewHistory = findViewById(R.id.listViewHistory);

        conversionHistory = new ArrayList<>();
        historyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, conversionHistory);
        listViewHistory.setAdapter(historyAdapter);
    }

    public void convertAmount(View view) {
        String euroAmountString = editTextAmount.getText().toString();
        if (!euroAmountString.isEmpty()) {
            double euroAmount = Double.parseDouble(euroAmountString);
            double dinarAmount = euroAmount * exchangeRate;
            textViewResult.setText(String.format("%.2f euros = %.2f dinars", euroAmount, dinarAmount));
            conversionHistory.add(String.format("%.2f euros = %.2f dinars", euroAmount, dinarAmount));
            historyAdapter.notifyDataSetChanged();
        }
    }
}
