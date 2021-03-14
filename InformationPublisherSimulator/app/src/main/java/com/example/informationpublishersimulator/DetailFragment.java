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
    MainActivity main; TextView txtId; TextView txtName; TextView txtMark; TextView txtClassName;
    Button btnFirst; Button btnPrevious; Button btnNext; Button btnLast;
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
        LinearLayout view_layout_detail = (LinearLayout) inflater.inflate(R.layout.detail_fragment, null);
        txtId = (TextView) view_layout_detail.findViewById(R.id.textViewId);
        txtName = view_layout_detail.findViewById(R.id.textViewName);
        txtClassName = view_layout_detail.findViewById(R.id.textViewClass);
        txtMark = view_layout_detail.findViewById(R.id.textViewMark);

        System.out.println("DetailFragment onCreateView before try catch");
        btnFirst = view_layout_detail.findViewById(R.id.btnFirst);
        btnPrevious = view_layout_detail.findViewById(R.id.btnPrevious);
        btnNext = view_layout_detail.findViewById(R.id.btnNext);
        btnLast = view_layout_detail.findViewById(R.id.btnLast);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMsgFromFragToMain("RED-FRAG", null, 0);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMsgFromFragToMain("RED-FRAG", null, 1);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMsgFromFragToMain("RED-FRAG", null, 2);
            }
        });

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMsgFromFragToMain("RED-FRAG", null, 3);
            }
        });

        return view_layout_detail;
    }
    @Override
    public void onMsgFromMainToFragment(User user, Integer btn) {// receiving a message from MainActivity (it may happen at any point in time)
        txtId.setText(user.id);
        txtMark.setText(user.mark.toString());
        txtName.setText(user.name);
        txtClassName.setText(user.className);
    }
}// DetailFragment