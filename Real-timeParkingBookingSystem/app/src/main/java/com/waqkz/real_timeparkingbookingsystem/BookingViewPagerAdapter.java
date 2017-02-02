package com.waqkz.real_timeparkingbookingsystem;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.waqkz.real_timeparkingbookingsystem.AccountCreationModule.SignInFragment;
import com.waqkz.real_timeparkingbookingsystem.AccountCreationModule.UserSignUpFragment;

/**
 * Created by waqkz on 1/27/17.
 */

public class BookingViewPagerAdapter extends FragmentPagerAdapter{

    private Context mContext;

    public BookingViewPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);

        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {

            return new BookingListFragment();
        } else {

            return new LocationListFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {

            return mContext.getString(R.string.user_booking_list);
        } else {

            return mContext.getString(R.string.user_location_list);
        }
    }
}
