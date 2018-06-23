package org.techtown.listview;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] listMenu = {"List1", "List2", "List3"}; // 리스트뷰 데이터

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listMenu); // 리스튜브 스타일, 데이터 선택

        ListView listView = (ListView) findViewById(R.id.mListView); // 리스트뷰 객체선언
        listView.setAdapter(adapter); // 리스트뷰 어댑터 연결


        /*
        listview short click listener
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position은 각 열의 위치
                if(position==0){
                    Toast.makeText(getApplicationContext(), "안녕하세요", Toast.LENGTH_LONG).show();
                }

                if(position==1){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });





    }
}
