package org.techtown.cadi_0714;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputText = (EditText) findViewById(R.id.inputText); // 리스트에 추가할 editText
        final EditText removeText = (EditText) findViewById(R.id.removeText); // 리스트에서 삭제할 인덱싱 넘버가 들어갈 editText
        Button btnAdd = (Button) findViewById(R.id.btnAdd); // add button
        Button btnDel = (Button) findViewById(R.id.btnDel); // delete button

        ListView mListView = (ListView) findViewById(R.id.mListView); // 리스트뷰 객체 참조
        final ArrayList<String> strList = new ArrayList<String>(); // String을 담을 arrayList 생성


        /**
         * 어댑터
         */
        final ArrayAdapter strAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strList);
        mListView.setAdapter(strAdapter); //Adapter 연결
        btnAdd.setOnClickListener(new View.OnClickListener() // add button listener
        {
            @Override
            public void onClick(View v) {
                String inputStr = inputText.getText().toString();//EditText의 문자를 유의미한 data로 받아준다.
                strList.add(inputStr);
                strAdapter.notifyDataSetChanged(); // 데이터 변경 동기화
            }
        });


        btnDel.setOnClickListener(new View.OnClickListener() // delete button listener
        {
            @Override
            public void onClick(View v) {
                int count = strAdapter.getCount(); // 배열의 갯수
                String removeStr = removeText.getText().toString(); // 삭제할 index number toString
                int removeInt = Integer.parseInt(removeStr); // int 형변환
                if (count > removeInt || removeInt < 0) // 인덱스와 배열범위 오차 확인
                {
                    strList.remove(removeInt); // 범위 내 index 삭제
                    strAdapter.notifyDataSetChanged(); // 동기화
                } else {
                    setDialog(); // 범위에 벗어났으므로 에러에 관한 다이얼로그 메시지 출력
                }
            }
        });
    }

    private void setDialog() // AlertDialog 설정
    {
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(this)
                .setTitle("에러 확인 메시지")
                .setMessage("앱을 종료하시겠습니까?")
                .setNegativeButton("돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "초기화면 복귀", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog msgDialog = msgBuilder.create();

        msgDialog.show();
    }
}