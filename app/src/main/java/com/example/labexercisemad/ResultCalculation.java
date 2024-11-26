package com.example.labexercisemad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultCalculation extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_calculation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    @Override
    protected void onStart() {

        TextView CustName, HouseLoanPrice, Coverage, MonthlyInstallment;

        String LoanPriceString, CoverageString, InstallmentString;

        Float installment, LoanPrice, CoverageInteger;

        CustName = findViewById(R.id.textView1);
        HouseLoanPrice = findViewById(R.id.textViewLoanPrice);
        Coverage = findViewById(R.id.textView3);
        MonthlyInstallment = findViewById(R.id.textViewMonth);

        Intent intent = getIntent();
        CustName.setText(intent.getStringExtra("Customer Name"));
        HouseLoanPrice.setText(intent.getStringExtra("House Loan Price"));
        Coverage.setText(intent.getStringExtra("Coverage Request"));

        LoanPriceString = intent.getStringExtra("House Loan Price");
        CoverageString = intent.getStringExtra("Coverage Request");

        LoanPrice = Float.parseFloat(LoanPriceString);
        CoverageInteger = Float.parseFloat(CoverageString);

        installment = (float) (0.1 * LoanPrice) / CoverageInteger;

        InstallmentString = installment.toString();

        MonthlyInstallment.setText(InstallmentString);













        super.onStart();
    }

}