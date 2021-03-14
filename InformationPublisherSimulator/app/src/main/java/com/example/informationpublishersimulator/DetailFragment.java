package com.example.informationpublishersimulator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import java.util.Date;


public class DetailFragment extends Fragment implements FragmentCallbacks {
    MainActivity main; TextView txtId; Button btnRedClock; TextView txtName; TextView txtMark; TextView txtClassName;
    public static DetailFragment newInstance(String strArg1) {
        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle(); bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }// newInstance
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("DetailFragment onCreate");
        // Activities containing this fragment must implement interface: MainCallbacks
        if (!(getActivity() instanceof MainCallbacks)) {
            throw new IllegalStateException( "Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity(); // use this reference to invoke main callbacks
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // inflate res/layout_red.xml which includes a textview and a button
        LinearLayout view_layout_red = (LinearLayout) inflater.inflate(R.layout.detail_fragment, null);
        txtId = (TextView) view_layout_red.findViewById(R.id.textViewId);
        txtName = view_layout_red.findViewById(R.id.textViewName);
        txtClassName = view_layout_red.findViewById(R.id.textViewClass);
        txtMark = view_layout_red.findViewById(R.id.textViewMark);

        System.out.println("DetailFragment onCreateView before try catch");
        // show string argument supplied by constructor (if any!)

        return view_layout_red;
    }
    @Override
    public void onMsgFromMainToFragment(User user) {// receiving a message from MainActivity (it may happen at any point in time)
        txtId.setText(user.id);
        txtMark.setText(user.mark.toString());
        txtName.setText(user.name);
        txtClassName.setText(user.className);
    }
}// DetailFragment