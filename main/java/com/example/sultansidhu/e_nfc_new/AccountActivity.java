package com.example.sultansidhu.e_nfc_new;

import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AccountActivity extends Activity{
    private NfcAdapter nfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nfcview);

        PackageManager pm = this.getPackageManager();
        // Checking if NFC Available on the device
        if(!pm.hasSystemFeature(PackageManager.FEATURE_NFC)){
            Toast.makeText(getApplicationContext(), "This device does not support NFC!", Toast.LENGTH_LONG).show();

        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN){
            //Android Beam is not supported
            Toast.makeText(getApplicationContext(), "Android Beam not supported on device!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "Android Beam and NFC is supported!", Toast.LENGTH_LONG).show();
            addSendButtonListener();

        }
    }

    public void sendFile(){ // Deleted the view parameter from within the sendFile function
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (!nfcAdapter.isEnabled()){
            Toast.makeText(getApplicationContext(), "Please enable NFC", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Settings.ACTION_NFC_SETTINGS));

        } else if (!nfcAdapter.isNdefPushEnabled()){
            Toast.makeText(getApplicationContext(), "Please enable Android Beam", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Settings.ACTION_NFCSHARING_SETTINGS));
        } else {
            String fileName = "meme.png"; // For the time being, to be replaced by stuff to send over NFC.

            // path to the user's public pictures directory
            File fileDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

            // create new file with the stuff to transfer
            File fileToSend = new File(fileDirectory, fileName);
            fileToSend.setReadable(true, false);

            nfcAdapter.setBeamPushUris(
                    new Uri[]{Uri.fromFile(fileToSend)}, this
            );


        }
    }


    public void addSendButtonListener(){
        Button sendButton = findViewById(R.id.transfer_btn);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFile();
            }
        });
    }


}
