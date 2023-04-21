package items;

public class Item {
    private int count;
    private String name;
    private String code;
    private float change;
    private String txtChange;
    private String vol;

    public Item(int count, String name, String code, float change, String txtChange, String vol){
        this.count = count;
        this.name = name;
        this.change = change;
        this.txtChange = txtChange;
        this.vol = vol;
        this.code = code;
    }

    @Override
    public String toString(){
        return "\n" + "Item " + count + " : Name: " + name + " ,Code: " + code + " ,Change: " + txtChange + " ,Vol: " + vol;
    }

    public double getChange(){
        return change;
    }
}
