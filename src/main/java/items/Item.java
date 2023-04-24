package items;

public class Item {
    private String name;
    private int count;
    private float price;

    public Item(String name, int count, float price){
        this.name = name;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString(){
        return "\n" + "Item " + count + " : Name: " + name + " ,Price: " + price;
    }

    public double getChange(){
        return price;
    }
}
