package com.waqkz.real_timeparkingbookingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ParkingDetailBookingActivity extends AppCompatActivity {

    private Button startBookingDate;
    private Button endBookingDate;
    private TextView startBookingDateText;
    private TextView endBookingDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_detail_booking);

        attachingWidgets();
        initializingComponents();
    }

    public void attachingWidgets(){

        startBookingDate = (Button) findViewById(R.id.start_booking_date);
        endBookingDate = (Button) findViewById(R.id.end_booking_date);
        startBookingDateText = (TextView) findViewById(R.id.startBookingDate);
        endBookingDateText = (TextView) findViewById(R.id.endBookingDate);
    }

    public void initializingComponents(){

        startBookingDate.setOnClickListener(v -> startDate());

        endBookingDate.setOnClickListener(v -> endDate());
    }

    public void startDate(){

        new SingleDateAndTimePickerDialog.Builder(this)
                //.bottomSheet()
                //.curved()
                //.minutesStep(15)
                .title("Start Booking Date")
                .listener(new SingleDateAndTimePickerDialog.Listener() {
                    @Override
                    public void onDateSelected(Date date) {

                        startBookingDateText.setText(date.getDate());

                    }
                }).display();

    }

    public void endDate(){

        new SingleDateAndTimePickerDialog.Builder(this)
                //.bottomSheet()
                //.curved()
                //.minutesStep(15)
                .title("End Booking Date")
                .listener(new SingleDateAndTimePickerDialog.Listener() {
                    @Override
                    public void onDateSelected(Date date) {

                        endBookingDateText.setText(date.toString());

                    }
                }).display();

    }

}
