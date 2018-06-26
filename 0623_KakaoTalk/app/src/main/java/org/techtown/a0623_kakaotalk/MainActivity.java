package org.techtown.a0623_kakaotalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.search_tab, menu);
        return true;
    }
}
