package com.waqkz.real_timeparkingbookingsystem.AccountCreationModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.waqkz.real_timeparkingbookingsystem.R;

public class AccountCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container_first, new SignInMemberShipTypeFragment())
                .commit();
    }
}
