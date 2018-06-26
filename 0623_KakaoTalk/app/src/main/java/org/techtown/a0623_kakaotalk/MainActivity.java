package org.techtown.a0623_kakaotalk;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView = null;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_tab, menu);
        return true;
    }
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tl_tabs);
        //viewpager
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_pager);

        //프래그먼트 배열 - 만들어 놓은 프래그먼트를 차례대로 넣음.
        Fragment[] arrFragments = new Fragment[5];
        arrFragments[0] = new FirstFragment();
        arrFragments[1] = new SecondFragment();
        arrFragments[2] = new ThirdFragment();
        arrFragments[3] = new FourthFragment();
        arrFragments[4] = new FifthFragment();

        //어답터 생성후 연결 - 배열을 인자로 추가.
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), arrFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }



    //pager adapter
    private class MyPagerAdapter extends FragmentPagerAdapter {

        private Fragment[] arrFragments;

        //생성자
        public MyPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }



        //Tab의 타이틀 설정
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "친구";
                case 1:
                    return "대화";
                case 2:
                    return "뉴스";
                case 3:
                    return "게임";
                case 4:
                    return "더보기";
                default:
                    return "";
            }
            //return super.getPageTitle(position);
        }
    }




}