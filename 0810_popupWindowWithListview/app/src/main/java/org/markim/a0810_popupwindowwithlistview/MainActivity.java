package org.markim.a0810_popupwindowwithlistview;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 팝업창을 닫는 버튼
    private Button btnPopupClose;

    // 팝업창을 띄우는 버튼
    private Button btnPopupLoad;

    // 팝업 윈도우
    private PopupWindow popupWindow;

    // 팝업 레이아웃에 위치한 editTxt
    private EditText txtData;

    // 팝업 레이아웃에 위치한 리스트 생성버튼
    private Button btnData;

    // 리스트뷰
    private ListView listPopup;

    // 데이터를 저장할 리스트
    List<String> list = new ArrayList<>();

    ArrayAdapter<String> adapter;

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

        // 리스트뷰 객체
        listPopup = (ListView) findViewById(R.id.listPopup);


        //리스트뷰와 리스트를 연결하기 위해 사용되는 어댑터
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        //리스트뷰의 어댑터를 지정해준다.
        listPopup.setAdapter(adapter);


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
            View layout = inflater.inflate(R.layout.layout_popup, (ViewGroup) findViewById(R.id.popupLayout));

            // focusable은 팝업윈도우를 실행시켰을 때 윈도우상의 아이템에 초점을 둘지 말지..
            popupWindow = new PopupWindow(layout, mWidthPixel-100, mHeightPixel-500, true);

            // 팝업윈도우 위치, 숫자값을 임의로 준다면 center에서 숫자값만큼 이동
            popupWindow.showAtLocation(layout, Gravity.CENTER, 0,0);

            // 팝업윈도우에 위치한 버튼을 사용할땐 뷰.findViewById로 해줌.
            btnPopupClose = (Button) layout.findViewById(R.id.btnPopupClose);
            btnPopupClose.setOnClickListener(disListener);

            // 팝업윈도우에 위치한 editText, 리스트 생성 button
            txtData = (EditText) layout.findViewById(R.id.txtData);
            btnData = (Button) layout.findViewById(R.id.btnData);

            btnData.setOnClickListener(addListener);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    // popupWindow dismiss 리스너
    private View.OnClickListener disListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popupWindow.dismiss();
        }
    };


    // btnData, 리스트 생성버튼을 눌렀을 시 적용될 리스너
    private View.OnClickListener addListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // editText data를 arrayList에 add함
            list.add(txtData.getText().toString());
            //리스트뷰 동기화
            adapter.notifyDataSetChanged();
        }
    };
}
