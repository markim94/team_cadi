package org.techtown.cadi_0714;

public class ListItem {

    String name;

    public ListItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ListItemView{" +
                "name='" + name + '\'' +
                '}';
    }

}
