package com.waqkz.real_timeparkingbookingsystem.AccountCreationModule;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kelvinapps.rxfirebase.RxFirebaseAuth;
import com.kelvinapps.rxfirebase.RxFirebaseUser;
import com.waqkz.real_timeparkingbookingsystem.AccountCreationModule.SignInFragment;
import com.waqkz.real_timeparkingbookingsystem.AccountCreationModule.UserSignUpForm;
import com.waqkz.real_timeparkingbookingsystem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserSignUpFragment extends Fragment {

    private EditText username;
    private EditText userFullName;
    private EditText userEmail;
    private EditText userPassword;
    private Button userSignUpButton;

    private String mUsername;
    private String mUserFullName;
    private String mUserEmail;
    private String mUserPassword;

    private UserSignUpForm userSignUpForm;

    private DatabaseReference mDatabase;

    private ProgressDialog mProgressDialog;


    public UserSignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_user_sign_up, container, false);

        mProgressDialog = new ProgressDialog(getActivity());

        mDatabase = FirebaseDatabase.getInstance().getReference();

        attachingWidgets(rootView);
        initializingComponents();

        return rootView;
    }

    public void attachingWidgets(View view){

        username = (EditText) view.findViewById(R.id.username);
        userFullName = (EditText) view.findViewById(R.id.user_full_name);
        userEmail = (EditText) view.findViewById(R.id.user_email);
        userPassword = (EditText) view.findViewById(R.id.user_password);
        userSignUpButton = (Button) view.findViewById(R.id.user_sign_up_button);
    }

    public void initializingComponents(){

        userSignUpButton.setOnClickListener(v -> authenticateUser());

    }

    public void authenticateUser(){

        mProgressDialog.setMessage("Signing up ...");
        mProgressDialog.show();

        mUsername = username.getText().toString();
        mUserFullName = userFullName.getText().toString();
        mUserEmail = userEmail.getText().toString();
        mUserPassword = userPassword.getText().toString();

        if (TextUtils.isEmpty(mUsername)
                && TextUtils.isEmpty(mUserFullName)
                && TextUtils.isEmpty(mUserEmail)
                && TextUtils.isEmpty(mUserPassword)) {

            mProgressDialog.dismiss();

            username.setError(getString(R.string.username));
            userFullName.setError(getString(R.string.user_full_name));
            userEmail.setError(getString(R.string.user_email));
            userPassword.setError(getString(R.string.user_password));

            return;
        }

        if (mUserPassword.length() < 6) {

            mProgressDialog.dismiss();
            Toast.makeText(getActivity(), getString(R.string.password_error), Toast.LENGTH_SHORT).show();

            return;
        }

        RxFirebaseAuth.createUserWithEmailAndPassword(FirebaseAuth.getInstance(), mUserEmail,
                mUserPassword).flatMap(x -> RxFirebaseUser.getToken(FirebaseAuth.getInstance().getCurrentUser(), false))
                .subscribe(token -> {
                    authComplete();
                    Log.i("RxFirebaseSample", "user token: " + token.getToken());
                }, throwable -> {
                    Log.e("RxFirebaseSample", throwable.toString());
                });

    }

    public void authComplete() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        userSignUpForm = new UserSignUpForm(user.getUid(),
                mUsername,
                mUserFullName,
                mUserEmail,
                mUserPassword);

        mDatabase.child("Parking").child("User")
                .child(userSignUpForm.getUserUUID())
                .setValue(userSignUpForm);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_first, new SignInFragment())
                .commit();

        mProgressDialog.dismiss();
        Toast.makeText(getActivity(), "Signed up successfully.", Toast.LENGTH_SHORT).show();
    }
}
