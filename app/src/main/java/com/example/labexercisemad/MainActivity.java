package com.example.labexercisemad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText txtCustomerName, txtHouseLoanPrice, txtCoverageRequest;

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

        btnCalculate = findViewById(R.id.button);



        btnCalculate.setOnClickListener(this::calculate);
    }

    public void calculate(View view){

        txtCustomerName = findViewById(R.id.editTextCustName);
        txtHouseLoanPrice = findViewById(R.id.editTextHouseLoan);
        txtCoverageRequest = findViewById(R.id.editTextCoverage);

        String custName, LoanPrice, Coverage;

        custName = txtCustomerName.getText().toString();
        LoanPrice = txtHouseLoanPrice.getText().toString();
        Coverage = txtCoverageRequest.getText().toString();

        Intent intent = new Intent(this,ResultCalculation.class);
        intent.putExtra("Customer Name", custName);
        intent.putExtra("House Loan Price", LoanPrice);
        intent.putExtra("Coverage Request", Coverage);
        startActivity(intent);

    }
}