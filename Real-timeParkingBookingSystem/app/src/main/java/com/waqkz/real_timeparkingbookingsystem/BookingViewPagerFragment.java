package com.waqkz.real_timeparkingbookingsystem;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waqkz.real_timeparkingbookingsystem.AccountCreationModule.UserSignUpPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookingViewPagerFragment extends Fragment {

    private ViewPager userBookingViewPager;
    private BookingViewPagerAdapter userBookingPagerAdapter;
    private TabLayout userBookingTabLayout;

    public BookingViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_booking_view_pager, container, false);

        attachingWidgets(rootView);
        initializingComponents();

        return rootView;
    }

    public void attachingWidgets(View view) {

        userBookingViewPager = (ViewPager) view.findViewById(R.id.booking_viewpager);
        userBookingTabLayout = (TabLayout) view.findViewById(R.id.booking_tabs);
    }

    public void initializingComponents() {

        userBookingPagerAdapter = new BookingViewPagerAdapter(getActivity(), getChildFragmentManager());
        userBookingViewPager.setAdapter(userBookingPagerAdapter);

        userBookingTabLayout.setupWithViewPager(userBookingViewPager);
    }
}
