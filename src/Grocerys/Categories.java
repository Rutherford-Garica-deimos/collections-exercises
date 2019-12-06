package Grocerys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Categories {
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
        for (int i = 0; i <catList.size(); i++){
            System.out.printf("Item - %s --- Number: %s%n",catList.get(i).getName(),catList.get(i).getNumber());
        }
        System.out.println();
    }
}
