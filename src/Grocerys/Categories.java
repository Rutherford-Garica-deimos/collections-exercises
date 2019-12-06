package Grocerys;

import java.util.ArrayList;

public class Categories {
    private String category;
    private ArrayList<Items> catList;


    public Categories(Items item){
        assert false;
        this.catList.add(item);
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<Items> getCatList() {
        return catList;
    }
}
