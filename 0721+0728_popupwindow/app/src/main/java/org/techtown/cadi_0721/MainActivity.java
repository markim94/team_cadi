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
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // 팝업창을 닫는 버튼
    private Button btnPopupClose;

    // 팝업창을 띄우는 버튼
    private Button btnPopupLoad;

    // 팝업 윈도우
    private PopupWindow popupWindow;

    private int mWidthPixel = 0;
    private int mHeightPixel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 윈도우 매니저, displayMetrics : 가로와 세로길이를 지정하기 위해
        WindowManager wm = getWindowManager(); // 윈도우 매니저 객체
        Display dp = wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        dp.getMetrics(dm);

        mWidthPixel = dm.widthPixels;
        mHeightPixel = dm.heightPixels;

        Button btnPopupLoad = (Button) findViewById(R.id.btnPopupLoad);
        btnPopupLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiatePopupWindow();

            }
        });

    }

    private void initiatePopupWindow(){
        try{

            // Mainactivity.this 권장
            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 뷰그룹으로 형변환
            View layout = inflater.inflate(R.layout.popuplayout, (ViewGroup) findViewById(R.id.popupLayout));

            // focusable은 팝업윈도우를 실행시켰을 때 윈도우상의 아이템에 초점을 둘지 말지..
            popupWindow = new PopupWindow(layout, mWidthPixel-100, mHeightPixel-500, true);

            // 팝업윈도우 위치, 숫자값을 임의로 준다면 center에서 숫자값만큼 이동
            popupWindow.showAtLocation(layout, Gravity.CENTER, 0,0);

            // 팝업윈도우에 위치한 버튼을 사용할땐 뷰.findViewById로 해줌.
            btnPopupClose = (Button) layout.findViewById(R.id.btnPopupClose);
            btnPopupClose.setOnClickListener(disListener);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    private View.OnClickListener disListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popupWindow.dismiss();
        }
    };

}


