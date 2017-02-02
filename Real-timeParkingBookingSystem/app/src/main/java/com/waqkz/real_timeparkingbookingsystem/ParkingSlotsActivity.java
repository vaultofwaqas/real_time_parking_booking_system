package com.waqkz.real_timeparkingbookingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.ListView;

import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;
import com.google.firebase.database.FirebaseDatabase;
import com.kelvinapps.rxfirebase.RxFirebaseDatabase;
import com.waqkz.real_timeparkingbookingsystem.AccountCreationModule.UserSignUpForm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingSlotsActivity extends AppCompatActivity {

    private ListView parkingSlotsList;
    private ParkingSlotsAdapter parkingSlotsAdapter;
    private ArrayList<ParkingSlots> parkingSlotsArrayList;

    private String LocationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_slots);

        LocationName = getIntent().getStringExtra("Location_Name");

        attachingWidgets();
        initializingComponents();

        parkingSlotsArrayList = new ArrayList<ParkingSlots>();
        parkingSlotsAdapter = new ParkingSlotsAdapter(ParkingSlotsActivity.this, parkingSlotsArrayList);
        parkingSlotsList.setAdapter(parkingSlotsAdapter);
    }

    public void attachingWidgets(){

        parkingSlotsList = (ListView) findViewById(R.id.parking_slots_list);
    }

    public void initializingComponents(){


        RxFirebaseDatabase.observeChildEvent(FirebaseDatabase.getInstance().getReference()
                .child("Parking")
                .child("Locations")
                .child(LocationName), Boolean.class).subscribe(user -> {

            user.getKey();

            parkingSlotsArrayList.add(new ParkingSlots(user.getKey()));
            parkingSlotsAdapter.notifyDataSetChanged();
        });

        parkingSlotsList.setOnItemClickListener((parent, view, position, id) -> parkingDetailBooking(position));
    }

    public void parkingDetailBooking(int position){

        Intent intent = new Intent(this, ParkingDetailBookingActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ParkingSlotsActivity.this, ParkingActivity.class);
        startActivity(intent);
    }
}
