package com.waqkz.real_timeparkingbookingsystem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by waqkz on 1/27/17.
 */

public class ParkingSlotsAdapter extends ArrayAdapter<ParkingSlots> {

    public ParkingSlotsAdapter(Context context, ArrayList<ParkingSlots> parkingSlots) {
        super(context, 0, parkingSlots);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.parking_slot_list, parent, false);
        }

        ParkingSlots parkingSlots = getItem(position);

        Button parkinglotButton = (Button) listItemView.findViewById(R.id.parking_slot_id);

        parkinglotButton.setText(parkingSlots.getParkingSlotsName());

        return listItemView;
    }
}
