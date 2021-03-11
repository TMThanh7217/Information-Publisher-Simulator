package com.example.informationpublishersimulator;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class UserListFragment extends Fragment {
    // this fragment shows a ListView
    MainActivity main; Context context = null; String message = "";
    // data to fill-up the ListView
    private String items[] = {"Text-on-Line-00", "Text-on-Line-01", "Text-on-Line-10"};

    private String[] ids = {"1oisdo;wqgos", "265+6ds49bd4b", "3321zxz da d a", "4as68486s4v"};
    private String[] names = {"A1", "B2", "C3", "D4"};
    private String[] classNames = {"asghv;oisabjiosajobsa", "zkxviohsdohoewopbw", "ajshcjsbbbbvv", "kxckvkcxv"};
    private Double[] marks = {9.5, 5.5, 6.6, 2.3};
    private Integer[] thumbnails = {R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user};

    // convenient constructor(accept arguments, copy them to a bundle, binds bundle to fragment)
    public static UserListFragment newInstance(String strArg) {
        UserListFragment fragment = new UserListFragment();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);

        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("UserList.crea");
        super.onCreate(savedInstanceState);
        try {
            context = getActivity(); // use this reference to invoke main callbacks
            main = (MainActivity) getActivity();
        }
        catch (IllegalStateException e) {
            throw new IllegalStateException("MainActivity must implement callbacks");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("UserList.creView");
        // inflate res/layout_blue.xml to make GUI holding a TextView and a ListView
        LinearLayout layout_blue = (LinearLayout) inflater.inflate(R.layout.list_fragment, null);
        // plumbing – get a reference to textview and listview
        final TextView txtBlue = (TextView) layout_blue.findViewById(R.id.textView1List);
        ListView listView = (ListView) layout_blue.findViewById(R.id.listView1List);
        listView.setBackgroundColor(Color.parseColor("#ffccddff"));
        // define a simple adapter to fill rows of the listview

        ArrayList<User> userList = new ArrayList<>();

        for (int i = 0; i < ids.length; i++) {
            userList.add(new User(ids[i],names[i], classNames[i], marks[i]));

        }
        System.out.println(userList.toString());
        CustomAdapter adapter = new CustomAdapter(context, R.layout.row_layout, userList, thumbnails);
        // bind intrinsic ListView to custom adapter
        listView.setAdapter(adapter);
        // show listview from the top
        listView.setSelection(0); listView.smoothScrollToPosition(0);
        // react to click events on listview’srows
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // inform enclosing MainActivity of the row’s position just selected
                main.onMsgFromFragToMain("BLUE-FRAG", "Blue selected row=" + position);
                txtBlue.setText("Blue selected row=" + position);
            }});
        // do this for each row (ViewHolder-Pattern could be used for better performance!)
        return layout_blue;
    }// onCreateView
}// class