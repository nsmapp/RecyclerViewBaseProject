package by.nepravsky.sm.recyclerviewbase.data;

import java.util.ArrayList;
import java.util.List;

public class BlackBox {

    List<Item> itemList = new ArrayList<>();


    public List<Item> getItemList(){

        itemList.add(new Item("1"," Name 13", "*********************"));
        itemList.add(new Item("2"," Name 23", "$$$$$$$$$$$$$$$$$$$$$"));
        itemList.add(new Item("3"," Name 34", "#####################"));
        itemList.add(new Item("4"," Name 5", "@@@@@@@@@@@@@@@@@@@@@"));
        itemList.add(new Item("8", "Name 9", "&&&&&&&&&&&&&&&&&&&&&"));

        return itemList;
    }
}
