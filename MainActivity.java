package com.example.sultansidhu.e_nfc_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Money moneyobj;

    // tasks

    // make a functional onCreate
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_account);
        addProceedButtonListener();
    }

    // add button listeners to the onCreate

    public void addProceedButtonListener(){
        moneyobj = null;

        Button proceedButton = findViewById(R.id.proceed_btn);

        TextView sendingAmount = findViewById(R.id.amount_text_field);
        final String amountToSend = sendingAmount.getText().toString().trim();

        TextView totalMoney = findViewById(R.id.current_balance_textview);
        final String currentBalance = totalMoney.getText().toString().trim();

        // if amountToSend <= currentBalance, create new money object to send.
        if (amountToSend.equals("")){
            Toast.makeText(getApplicationContext(), "Please enter amount to send", Toast.LENGTH_SHORT).show();
        } else if (Float.parseFloat(amountToSend) > Float.parseFloat(currentBalance)){
            Toast.makeText(getApplicationContext(), "Not enough funds!", Toast.LENGTH_SHORT).show();
        } else {
            moneyobj = new Money("Admin", Double.parseDouble(amountToSend), "CAD");
        }

        // setting the onclicklistener for the proceedbutton

        proceedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                assert moneyobj != null;
                try{
                    goToTransactionScreen(moneyobj);
                } catch (NullPointerException npe){
                    npe.printStackTrace();
                }
            }
        });

    }

    //in the button listener method, make sure data is entered and then
    // pass intent to go to the next page

    public void goToTransactionScreen(Money money){
        Intent tmp = new Intent(this, MainActivity.class);
        tmp.putExtra("sender", money.getsenderID());
        tmp.putExtra("money", money.getAmount());
        tmp.putExtra("currencyType", money.currencyType());
        startActivity(tmp);
    }
}