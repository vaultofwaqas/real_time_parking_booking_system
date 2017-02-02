package com.waqkz.real_timeparkingbookingsystem.AccountCreationModule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.waqkz.real_timeparkingbookingsystem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInMemberShipTypeFragment extends Fragment {

    private Button signInWithAdmin;
    private Button signInWithUser;


    public SignInMemberShipTypeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sign_in_member_ship_type, container, false);

        attachingWidgets(rootView);
        initializingComponents();

        return rootView;
    }

    public void attachingWidgets(View view){

        signInWithAdmin = (Button) view.findViewById(R.id.signInWithAdmin);
        signInWithUser = (Button) view.findViewById(R.id.signInWithUser);
    }

    public void initializingComponents(){

        signInWithAdmin.setOnClickListener(v -> signInAdmin());

        signInWithUser.setOnClickListener(v -> signInUser());
    }

    public void signInAdmin(){

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_first, new SignInFragment())
                .addToBackStack("SignInMemberShipTypeFragment")
                .commit();

    }

    public void signInUser(){

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_first, new UserViewPagerFragment())
                .addToBackStack("SignInMemberShipTypeFragment")
                .commit();
    }
}
