package com.waqkz.real_timeparkingbookingsystem.AccountCreationModule;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.waqkz.real_timeparkingbookingsystem.R;

/**
 * Created by waqkz on 1/27/17.
 */

public class UserSignUpPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public UserSignUpPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);

        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {

            return new SignInFragment();
        } else {

            return new UserSignUpFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {

            return mContext.getString(R.string.user_sign_in);
        } else {

            return mContext.getString(R.string.user_sign_up);
        }
    }
}
