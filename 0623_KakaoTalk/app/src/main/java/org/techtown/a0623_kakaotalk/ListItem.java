package org.techtown.a0623_kakaotalk;

import android.graphics.drawable.Drawable;

public class ListItem {
    private Drawable profile;
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





}
