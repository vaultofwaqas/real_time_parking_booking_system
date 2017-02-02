package com.waqkz.real_timeparkingbookingsystem;


import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kelvinapps.rxfirebase.RxFirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationListFragment extends Fragment {

    private ListView locationList;
    private LocationListAdapter locationListAdapter;
    private ArrayList<Locations> arrayListLocations;

    private DatabaseReference mDatabase;

    public LocationListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_location_list, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        attachingWidgets(rootView);
        initializingComponents();

        arrayListLocations = new ArrayList<Locations>();
        locationListAdapter = new LocationListAdapter(getActivity(), arrayListLocations);
        locationList.setAdapter(locationListAdapter);

        return rootView;
    }

    public void attachingWidgets(View view){

        locationList = (ListView) view.findViewById(R.id.location_list);
    }

    public void initializingComponents(){

        RxFirebaseDatabase.observeChildEvent(mDatabase
                .child("Parking")
                .child("Locations"), Locations.class).subscribe(user -> {

            arrayListLocations.add(new Locations(user.getKey()));
            locationListAdapter.notifyDataSetChanged();
        });

        locationList.setOnItemClickListener((parent, view, position, id) -> openingParkingSlots(position));
    }

    public void openingParkingSlots(int position){

        String locationName = arrayListLocations.get(position).getLocationName();

        Intent intent = new Intent(getActivity(), ParkingSlotsActivity.class);
        intent.putExtra("Location_Name", locationName);
        startActivity(intent);

        getActivity().finish();
    }

}
