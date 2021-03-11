package com.example.informationpublishersimulator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements MainCallbacks {
    FragmentTransaction ft; DetailFragment detailFragment; UserListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        // create a new BLUE fragment - show it
        System.out.println("Main.create");
        ft = getSupportFragmentManager().beginTransaction(); listFragment = UserListFragment.newInstance("first-blue");
        ft.replace(R.id.main_holder_list, listFragment); ft.commit();
        // create a new RED fragment - show it
        ft = getSupportFragmentManager().beginTransaction(); detailFragment = DetailFragment.newInstance("first-red");
        ft.replace(R.id.main_holder_detail, detailFragment); ft.commit();
    }
    // MainCallback implementation (receiving messages coming from Fragments)
    @Override
    public void onMsgFromFragToMain(String sender, String strValue) {
        System.out.println("Main.onMsgv");
        // show message arriving to MainActivity
        Toast.makeText(getApplication(), " MAIN GOT>> " + sender + "\n" + strValue, Toast.LENGTH_LONG).show();
        if (sender.equals("RED-FRAG")) { /* TODO: if needed, do here something on behalf of the RED fragment*/ }
        if (sender.equals("BLUE-FRAG")) {
            try { // forward blue-data to detailFragment using its callback method
                detailFragment.onMsgFromMainToFragment("\nSender: " + sender + "\nMsg: " + strValue);
            }
            catch (Exception e) { Log.e("ERROR", "onStrFromFragToMain " + e.getMessage()); }
        }
    }
}