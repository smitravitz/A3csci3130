package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class CreateBusinessActivity extends Activity {

    private ListView firebaseBusinessList;
    private Button submitButton;
    private EditText businessNameField, businessNumberField,
            businessPrimaryTypeField,   businessAddressField, businessProvTerrField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_activity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);

        businessNumberField = (EditText) findViewById(R.id.number);
        businessNameField = (EditText) findViewById(R.id.name);
        businessPrimaryTypeField = (EditText) findViewById(R.id.primaryType);
        businessAddressField = (EditText) findViewById(R.id.address);
        businessProvTerrField = (EditText) findViewById(R.id.provTerr);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String bID = appState.firebaseReference.push().getKey();
        String number = businessNumberField.getText().toString();
        String name = businessNameField.getText().toString();
        String primaryType = businessNameField.getText().toString();
        String address = businessNameField.getText().toString();
        String provTerr = businessNameField.getText().toString();
        Business business = new Business(number,name,primaryType,address,provTerr,bID);

        appState.firebaseReference.child(bID).setValue(business);

        finish();
    }
}
