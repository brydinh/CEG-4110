package com.brydinh.tabtest;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import android.support.v4.app.ActivityCompat;
import android.Manifest;

import yuku.ambilwarna.AmbilWarnaDialog;


public class Tab2 extends Fragment {

    private PaintView paintView;
    private Button clearBtn;
    private Button changeColorBtn;
    private Button saveBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab2, container, false);

        paintView = rootView.findViewById(R.id.PaintView);

        saveBtn = rootView.findViewById(R.id.button);
        saveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                View content = paintView;
                content.setDrawingCacheEnabled(true);
                content.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
                Bitmap bitmap = content.getDrawingCache();
                String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(path + "/image.png");

                FileOutputStream ostream;

                try {

                    if (isExternalStorageWritable()) {
                        file.createNewFile();
                        ostream = new FileOutputStream(file);
                        bitmap.compress(CompressFormat.PNG, 100, ostream);
                        ostream.flush();
                        ostream.close();
                        Toast.makeText(getActivity(), "Image sucessfully saved", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getActivity(), "External storage is not available for write", Toast.LENGTH_LONG).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "You need external permissions to do a storage write!", Toast.LENGTH_LONG).show();
                }
            }


        });


        changeColorBtn = rootView.findViewById(R.id.button1);
        changeColorBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OpenColorPicker(false);
            }
        });


        clearBtn = rootView.findViewById(R.id.button2);
        clearBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paintView.reset();
            }

        });

        return rootView;
    }


    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    private void OpenColorPicker(boolean AlphaSupport) {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(getActivity(), paintView.GetColor(), new AmbilWarnaDialog.OnAmbilWarnaListener() {

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                return;
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                paintView.setColor(color);
            }
        });
        ambilWarnaDialog.show();
    }

}




