package org.techtown.cadi_0721;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;


public class MainActivity extends AppCompatActivity {

    private Button btnPopupClose;
    private Button btnPopupLoad;
    private PopupWindow popupWindow;

    private int mWidthPixel = 0;
    private int mHeightPixel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WindowManager wm = getWindowManager(); // 윈도우 매니저 객체로 생성
        Display dp = wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        dp.getMetrics(dm);

        mWidthPixel = dm.widthPixels;
        mHeightPixel = dm.heightPixels;

        Button btnPopupLoad = (Button) findViewById(R.id.btnPopupLoad);
        btnPopupLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void initiatePopupWindow(){
        try{
            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View layout = inflater.inflate(R.layout.popuplayout, (ViewGroup) findViewById(R.id.popupLayout));

            popupWindow = new PopupWindow(layout, mWidthPixel-100, mHeightPixel-500);
            popupWindow.showAtLocation(layout, Gravity.CENTER, 0,0);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}


