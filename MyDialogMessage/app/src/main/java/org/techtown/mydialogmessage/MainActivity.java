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


        //버튼 다이얼로그 메시지
        AlertDialog.Builder newBuilder = new AlertDialog.Builder(this);
        newBuilder.setTitle("오늘 수업을 끝낼까요?");
        newBuilder.setMessage("오늘 수업을 끝내시겠습니까?");
        newBuilder.setNegativeButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        newBuilder.setPositiveButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "끝내지 않습니다.", Toast.LENGTH_SHORT).show();
            }

        });


        // AlertDialog의 Builder를 이용해 정의한 newBuilder를 dialog
        final AlertDialog dialog = newBuilder.create();


        // 버튼 클릭시 dialog message를 show함.
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();

            }
        });

    }
}
