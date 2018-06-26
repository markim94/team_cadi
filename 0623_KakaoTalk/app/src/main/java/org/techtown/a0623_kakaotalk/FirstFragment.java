package org.techtown.a0623_kakaotalk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {


    private ListView mListView = null;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] strName = {"김준형", "김하나", "김두울", "김세엣", "김다섯", "김여섯", "김일곱", "김여덟"};
        String[] strMessage = {"상태메시지1", "상메2", "상태message3", "상태msg4", "statemsg5", "state메시지6", "statemessage7", "상msg8"};

        int nCnt = 0;
        ArrayList<ItemData> mData = new ArrayList<>();
        for (int i = 0; i < 1000; ++i) {
            ItemData ItemData = new ItemData();
            ItemData.strName = strName[nCnt];
            ItemData.strMessage = strMessage[nCnt++];
            mData.add(ItemData);
        }


        mListView = (ListView) mListView.findViewById(R.id.listView);
        ListAdapter adapter = new ListAdapter(mData);
        mListView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    //데이터 클래스 생성
    public static class ItemData{
        public String strName;
        public String strMessage;
    }

    //adapter 생성
    public class ListAdapter extends BaseAdapter {

        LayoutInflater inflater = null;
        private ArrayList<ItemData> mData = null;
        private int mListConut = 0;

        public ListAdapter(ArrayList<ItemData> _mData){
            mData = _mData;
            mListConut = mData.size();
        }

        @Override
        public int getCount() {
            return mListConut;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                final Context context = parent.getContext();
                if(inflater == null){
                    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                }
                convertView = inflater.inflate(R.layout.friend_list, parent, false);
            }

            /**
             * 친구 이름, 상태메시지
             */
            TextView mName = (TextView) convertView.findViewById(R.id.friendName);
            TextView mMessage = (TextView) convertView.findViewById(R.id.stateMessage);

            mName.setText(mData.get(position).strName);
            mMessage.setText(mData.get(position).strMessage);


            return convertView;
        }
    }







}
