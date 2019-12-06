package Grocerys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Categories {
    private String category;
    private ArrayList<Items> catList = new ArrayList<>();


    public Categories(){
//        assert false;
//        this.catList.add(item);
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<Items> getCatList() {
        return catList;
    }

    public void addItem(Items item){
        this.catList.add(item);
    }

    public void sortList(){
        assert false;
        catList.sort(Comparator.comparing(Items::getName));
    }

    public void printItems(){
        for (Items items : catList) {
            System.out.printf("Item - %s --- Number: %s%n", items.getName(), items.getNumber());
        }
        System.out.println();
    }
}
