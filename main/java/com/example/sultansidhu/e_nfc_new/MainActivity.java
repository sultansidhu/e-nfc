package com.example.sultansidhu.e_nfc_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

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
        Button proceedButton = findViewById(R.id.proceed_btn);

        TextView sendingAmount = findViewById(R.id.amount_text_field);
        final String amountToSend = sendingAmount.getText().toString().trim();

        TextView totalMoney = findViewById(R.id.current_balance_textview);
        final String currentBalance = totalMoney.getText().toString().trim();

        // if amountToSend <= currentBalance, create new money object to send.

        // in the process of creation, make sure that data is entered into these fields.


        // lastly, adding intent to go to the next screen.
        goToTransactionScreen();

    }

    //in the button listener method, make sure data is entered and then
    // pass intent to go to the next page

    public void goToTransactionScreen(){
        Intent tmp = new Intent(this, MainActivity.class);
        startActivity(tmp);
    }
}