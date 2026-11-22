package item;

public class Key extends Item{

    public String itemName;

    public Key(String itemName){
        super(itemName);
        this.itemName = itemName;
    }

    @Override
    public void ShowInfo(){
        System.out.println("단순한 녹슨 열쇠");
    }
}
