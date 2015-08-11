package com.spinno.listory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class ChatActivity extends Activity {

    LinearLayout chatlayout ;
    ImageView sendbutton ;
    EditText chattextEdt ;
    ScrollView scview ;
    LinearLayout chat_one_layout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatlayout = (LinearLayout) findViewById(R.id.chat_linear_layout);
        sendbutton = (ImageView) findViewById(R.id.send_button);
        chattextEdt = (EditText) findViewById(R.id.edit_text);
        scview = (ScrollView) findViewById(R.id.scroll_view);
        chat_one_layout = (LinearLayout) findViewById(R.id.chat_one_layout);

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chatlayout.addView(chatview(R.layout.chat_bubble_layout ,""+chattextEdt.getText().toString() ));
                scview.fullScroll(View.FOCUS_DOWN);
            }
        });



        chat_one_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChatActivity.this, FinalGroceryActivity.class));
            }
        });


    }



    private View chatview(int layout_name , String s   ) {

        LayoutInflater layoutInflater =
                (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View addView = layoutInflater.inflate(layout_name, null);
        final TextView pname = (TextView) addView.findViewById(R.id.chat_text_in_bubble);

        pname.setText(s);
        return addView ;
    }



}
