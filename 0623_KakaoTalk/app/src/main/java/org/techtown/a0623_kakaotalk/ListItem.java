package org.techtown.a0623_kakaotalk;

import android.graphics.drawable.Drawable;

/**
 * 리스트 뷰 홀더
 */
public class ListItem {
    private Drawable profile;

    /* 이미지 배열 적용시 int형으로
    private int profile2;
    */

    private String friendName;
    private String stateMessage;


    public void setProfile(Drawable img){
        profile = img;
    }

    public void setFriendName(String name){
        friendName = name;
    }

    public void setStateMessage(String message){
        stateMessage = message;
    }

    public Drawable getProfile() {
        return this.profile;
    }

    public String getName(){
        return this.friendName;
    }

    public String getMessage(){
        return this.stateMessage;
    }


    /* 이미지 배열 적용 메서드
    public void setProfile(int i) {
        profile2 = i;
    }
    */
}
