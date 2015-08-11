package com.spinno.listory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.ButterKnife;

/**
 * Created by samir on 01/08/15.
 */
public class FragmentGroup extends Fragment {

    LinearLayout layoutclicking ;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_group, container, false);
        ButterKnife.bind(this, v);

        layoutclicking = (LinearLayout) v.findViewById(R.id.layout_id_in_fragment_group);


           layoutclicking.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   getActivity().startActivity(new Intent(getActivity() , ChatActivity.class));
               }
           });
        return v;
    }


    public static FragmentGroup newInstance(String text) {

        FragmentGroup f = new FragmentGroup();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }

}
