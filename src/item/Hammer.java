package item;



public class Hammer extends Item {
    public String itemName;

    public Hammer(String itemName) { super(itemName); }

    @Override
    public String ShowInfo(){
        return "무거운 망치";
    }

    @Override
    public String NotUse(){
        return "물건을 부술 수 있어 보인다.";
    }

    @Override
    public Boolean useCan(){
        return false;
    }

}
