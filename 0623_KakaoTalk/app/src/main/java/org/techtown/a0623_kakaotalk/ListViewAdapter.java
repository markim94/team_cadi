package org.techtown.a0623_kakaotalk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListItem> listItemList = new ArrayList<ListItem>();
    

    //생성자
    public ListViewAdapter(){


    }

    @Override
    public int getCount() {
        return listItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView ==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.friend_list, parent, false);
        }

        ImageView profile = (ImageView) convertView.findViewById(R.id.profile);
        TextView friendName = (TextView) convertView.findViewById(R.id.friendName);
        TextView stateMessage = (TextView) convertView.findViewById(R.id.stateMessage);

        // listItemList의 position에 위치한 데이터 갖고오기
        ListItem listItem = listItemList.get(position);

        profile.setImageDrawable(listItem.getProfile());
        friendName.setText(listItem.getName());
        stateMessage.setText(listItem.getMessage());

        return convertView;
    }

    /**
     * addItem이 아닌 배열을 커스텀리스트뷰에 적용하기(검색해볼 것)
     
    int[] profileArr = {R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile};
    String[] nameArr = {"홍길동", "김길동", "김동길", "홍동길", "이길동", "이동길", "박동길", "박길동"};
    String[] msgArr = {"msg1", "msg2", "msg3", "msg4", "메시지5", "메시지6", "메시지7", "메시지8"};
     */

    public void addItem(Drawable profile, String name, String message) {
        ListItem item = new ListItem();

        item.setProfile(profile);
        item.setFriendName(name);
        item.setStateMessage(message);

        listItemList.add(item);
    }





}