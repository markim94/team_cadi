package org.techtown.cadi_0512;

import android.content.Intent;
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


        Button button = (Button) findViewById(R.id.button); // 버튼에 대한 객체 생성
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"안녕하세요", Toast.LENGTH_LONG).show(); // 버튼 클릭시 토스트 메시지 출력
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class); // 액티비티 전환에 관한 인텐트 생성
                startActivity(intent); // 인텐트 실행(액티비티 전환)
            }
        });
        

    }
}
