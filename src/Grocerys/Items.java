package Grocerys;

import java.util.ArrayList;

public class Items {
    protected String category;
    protected String name;
    protected int number;

    public Items(){
        this.number = 0;
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
}
