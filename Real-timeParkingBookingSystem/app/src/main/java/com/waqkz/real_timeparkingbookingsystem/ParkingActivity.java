package com.waqkz.real_timeparkingbookingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kelvinapps.rxfirebase.RxFirebaseDatabase;
import com.waqkz.real_timeparkingbookingsystem.AccountCreationModule.UserSignUpForm;

public class ParkingActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        mAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mAuthListener = firebaseAuth -> initializeUser(firebaseAuth);

    }

    public void initializeUser(FirebaseAuth firebaseAuth) {

        currentUser = firebaseAuth.getCurrentUser();

        if (currentUser != null) {

           if(mDatabase.child("Parking").child("Admin").getKey().equals(currentUser.getUid())){

           }

            RxFirebaseDatabase.observeSingleValueEvent(mDatabase.child("Parking")
                    .child("User").child(currentUser.getUid()), UserSignUpForm.class)
                    .subscribe(user -> {

                        if (currentUser.getUid().equals(user.getUserUUID())){

                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.fragment_container_second, new BookingViewPagerFragment()).commit();
                        }});
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
