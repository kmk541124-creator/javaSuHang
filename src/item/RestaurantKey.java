package item;

public class RestaurantKey extends Item{

    public RestaurantKey(String itemName){
        super(itemName);
    }

    @Override
    public String ShowInfo(){
        return "식당으로 가는 열쇠";
    }

    @Override
    public String NotUse(){
        return "여기서 사용할 순 없을것 같다";
    }

    @Override
    public Boolean useCan(){
        return false;
    }
}
