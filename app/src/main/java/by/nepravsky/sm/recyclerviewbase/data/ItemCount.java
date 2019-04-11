package by.nepravsky.sm.recyclerviewbase.data;

public class ItemCount implements Entity{

    String itemCount = "";

    public ItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }
}
