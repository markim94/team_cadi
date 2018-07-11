package org.techtown.mydialogmessage;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 다이얼로그 메시지 생성
        AlertDialog.Builder newBuilder = new AlertDialog.Builder(this);

        // 다이얼로그 메시지 타이틀 설정
        newBuilder.setTitle("어플리케이션을 종료여부");

        // 다이얼로그 메시지 본문 내용 설정
        newBuilder.setMessage("어플리케이션을 종료하시겠습니까?");

        // 다이얼로그 메시지 icon 설정
        newBuilder.setIcon(R.drawable.icon);

        newBuilder.setNegativeButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // '예' 버튼 클릭
                finish();
            }
        });

        newBuilder.setPositiveButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // '아니요' 버튼 클릭
                Toast.makeText(getApplicationContext(), "끝내지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // '취소' 버튼 클릭
        newBuilder.setNeutralButton("취소", null);


        // AlertDialog.Builder를 이용해 정의한 newBuilder를 dialog에 적용
        final AlertDialog dialog = newBuilder.create();

        // 버튼 클릭시 dialog message를 show함
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }
}
