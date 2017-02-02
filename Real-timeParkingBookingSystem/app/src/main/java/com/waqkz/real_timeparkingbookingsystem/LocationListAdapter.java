package com.waqkz.real_timeparkingbookingsystem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by waqkz on 1/27/17.
 */

public class LocationListAdapter extends ArrayAdapter<Locations> {

    public LocationListAdapter(Context context, ArrayList<Locations> locations) {
        super(context, 0, locations);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.location_list, parent, false);
        }

        Locations locations = getItem(position);

        TextView locationText = (TextView) listItemView.findViewById(R.id.location_id);

        locationText.setText(locations.getLocationName());

        return listItemView;
    }
}
