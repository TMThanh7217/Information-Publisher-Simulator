package com.example.informationpublishersimulator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements MainCallbacks{
    FragmentTransaction ft; DetailFragment detailFragment; UserListFragment userListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// create a new BLUE fragment - show it
        ft = getSupportFragmentManager().beginTransaction(); userListFragment = UserListFragment.newInstance("first-blue");
        ft.replace(R.id.main_holder_list, userListFragment); ft.commit();
// create a new RED fragment - show it
        ft = getSupportFragmentManager().beginTransaction(); detailFragment = DetailFragment.newInstance("first-red");
        ft.replace(R.id.main_holder_detail, detailFragment); ft.commit();
    }
    // MainCallback implementation (receiving messages coming from Fragments)
    @Override
    public void onMsgFromFragToMain(String sender,  User user, Integer btn) {
// show message arriving to MainActivity
        if (sender.equals("RED-FRAG")) {
            try { // forward blue-data to detailFragment using its callback method
                userListFragment.onMsgFromMainToFragment(user, btn);
            }
            catch (Exception e) { Log.e("ERROR", "onStrFromFragToMain " + e.getMessage()); }
        }
        if (sender.equals("BLUE-FRAG")) {
            try { // forward blue-data to detailFragment using its callback method
                detailFragment.onMsgFromMainToFragment(user, btn);
            }
            catch (Exception e) { Log.e("ERROR", "onStrFromFragToMain " + e.getMessage()); }
        }
    }
}