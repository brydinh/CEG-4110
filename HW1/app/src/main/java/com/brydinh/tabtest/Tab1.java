package com.brydinh.tabtest;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import java.util.Random;

public class Tab1 extends Fragment {

    private Button changeColorBtn;
    private EditText eEdit;
    private String checkThis;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab1, container, false);
        eEdit = rootView.findViewById(R.id.editText);
        textView = rootView.findViewById(R.id.textView);
        changeColorBtn = rootView.findViewById(R.id.button1);

        changeColorBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkThis = eEdit.getText().toString();

                if (TextUtils.isEmpty(checkThis)) {
                    Toast.makeText(getActivity(), "Needs input into textfield", Toast.LENGTH_LONG).show();
                } else {
                    Random rnd = new Random();

                    int red = rnd.nextInt(256);
                    int green = rnd.nextInt(256);
                    int blue = rnd.nextInt(256);
                    int color = Color.argb(255, red, green, blue);

                    eEdit.setTextColor(color);

                    String toHex = Integer.toHexString(color);
                    textView.setText("COLOR: " + red + "r, " + green + "g, " + blue + "b, " + "#" + toHex);
                }
            }

        });

        return rootView;
    }
}
