package org.techtown.a0623_kakaotalk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends ListFragment {

    ListViewAdapter adapter;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*
        리스트뷰 어댑터 설정
         */
        adapter = new ListViewAdapter();
        setListAdapter(adapter);

        /*
        친구 데이터 삽입
         */
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile),"name","message");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile),"name","message");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile),"name","message");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile),"name","message");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile),"name","message");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile),"name","message");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile),"name","message");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile),"name","message");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile),"name","message");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile),"name","message");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /*
    클릭 리스너 설정
     */
    public void onListItemClick(ListView l, View v, int position, long id){
        ListItem item = (ListItem) l.getItemAtPosition(position);

        Drawable profile = item.getProfile();
        String frinedName = item.getName();
        String stateMessage = item.getMessage();

        Toast.makeText(getContext(),position+1 +"번째 친구를 클릭함", Toast.LENGTH_LONG).show();

    }

}
