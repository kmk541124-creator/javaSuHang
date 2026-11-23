package item;

public class Fire extends Item{

    public Fire(String itemName){
        super(itemName);
    }

    @Override
    public String ShowInfo(){
        return "불을 붙힐 수 있는 성냥";
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
