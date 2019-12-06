package Grocerys;

import util.Input;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class GroceryList {

    private static Input input = new Input();

//    public static HashMap<Integer, Items> list = new HashMap<>();
    private static HashMap<String,Categories> list = new HashMap<>();

    public static int listSize = 1;
//    public static int[] listOrderCat;
//    public static int[] listOrderName;

    private static String[] categories = {"bathroom","fruits/veggies","kitchen supplies","meats"};


    public static void main(String[] args) {
        groceryListApp();

    }

    private static void groceryListApp() {
        //        System.out.println("Do you want to create a grocery list?(yes/no)");
        String yesNo = input.getString("Do you want to create a grocery list? (yes/no)");
        if (!yesNo.equalsIgnoreCase("no") && !yesNo.equalsIgnoreCase("n")) {
            createList();
            System.out.println("\nList is a follows...\n\n");
            if (list.size() == 0) {
                System.out.println("Error: there is no list...");
                groceryListApp();
            } else {
//                Collections.sort(list.entrySet());
                for (HashMap.Entry<String,Categories> category : list.entrySet()){
                    category.getValue().sortList();
                    System.out.println("--------------------------------------------------------");
                    System.out.printf("Category: %s%n%n",category.getKey());
                    category.getValue().printItems();
                }
//                for (HashMap.Entry<Integer, Items> entry : list.entrySet()) {
//                    System.out.printf("Item - %s -- category: %s%n Item: %s%n Number: %s%n%n", entry.getKey(),
//                            entry.getValue().getCategory(),
//                            entry.getValue().getName(),
//                            entry.getValue().getNumber());
//                }
                groceryListApp();
            }
        } else {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    private static void createList() {
        String addYesNo = input.getString("Do you want to add a item to the list?");
        if (addYesNo.equalsIgnoreCase("yes") || addYesNo.equalsIgnoreCase("y")) {
            System.out.println("Select a category:\n");
            for (int i = 0; i < categories.length; i++) {
                System.out.printf("%s - %s%n", i, categories[i]);
            }
            System.out.printf("%s - to cancel%n", (categories.length + 1));
            int chooseCat = input.getInt(0, (categories.length + 1));
            if (chooseCat != (categories.length + 1)) {
                String cat = categories[chooseCat];
                input.inputCleaner();
                String itemName = input.getString("Enter the items name:");
//                input.inputCleaner();
                int numberBuy = input.getInt("Enter the number you wish to buy:");
//                Items newItem = new Items(cat, itemName, numberBuy);
//                list.put(listSize, newItem);
                input.inputCleaner();
                Items newItem = new Items(itemName, numberBuy);
                if (!list.containsKey(cat)){
                    list.put(cat,new Categories());
                }
                list.get(cat).addItem(newItem);

//                listSize++;
                createList();
            } else {
                System.out.println("finalizing list...");
                createList();
            }
        }
    }

//    public static void organizeList(){
////        listOrderCat = new int[list.size()];
////        listOrderName = new int[list.size()];
//
//    }

}
