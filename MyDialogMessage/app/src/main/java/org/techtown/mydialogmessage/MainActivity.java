package org.techtown.mydialogmessage;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //버튼 다이얼로그 메시지
        AlertDialog.Builder newBuilder = new AlertDialog.Builder(this)
                .setTitle("오늘 수업을 끝낼까요?")
                .setMessage("오늘 수업을 끝내시겠습니까?")
                .setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                //.setPositiveButton
                ;
        final AlertDialog dialog = newBuilder.create();




        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();

            }
        });

    }
}
