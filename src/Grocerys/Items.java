package Grocerys;

import java.util.ArrayList;
import java.util.HashMap;

public class Items {
    protected String category;
//    private HashMap<String, Integer> listItem;
    protected String name;
    protected int number;
//
//    public Items(String category, String name, int number) {
//        this.category = category;
//        this.name = name;
//        this.number = number;
//
//    }

    public Items( String name, int number) {
        this.name = name;
        this.number = number;

    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
