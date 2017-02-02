package com.waqkz.real_timeparkingbookingsystem.AccountCreationModule;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waqkz.real_timeparkingbookingsystem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserViewPagerFragment extends Fragment {

    private ViewPager userSignUpViewPager;
    private UserSignUpPagerAdapter userPagerAdapter;
    private TabLayout userTabLayout;


    public UserViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_user_view_pager, container, false);

        attachingWidgets(rootView);
        initializingComponents();

        return rootView;
    }

    public void attachingWidgets(View view){

        userSignUpViewPager = (ViewPager) view.findViewById(R.id.signup_viewpager);
        userTabLayout = (TabLayout) view.findViewById(R.id.tabs);
    }

    public void initializingComponents(){

        userPagerAdapter = new UserSignUpPagerAdapter(getActivity(), getChildFragmentManager());
        userSignUpViewPager.setAdapter(userPagerAdapter);

        userTabLayout.setupWithViewPager(userSignUpViewPager);
    }

}
