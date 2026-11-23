package item;

public class CardKey extends Item{

    private int level = 4;

    public CardKey(String itemName){
        super(itemName);
        this.level = 4;
    }

    @Override
    public String ShowInfo(){
        return "문을 열수 있는 카드키";
    }

    @Override
    public String NotUse(){
        return "여기서 사용할 순 없을것 같다";
    }

    @Override
    public Boolean useCan(){
        return false;
    }

    public void levelUp(){
        this.level = 5;
    }

    @Override
    public Boolean Interact(){
        if(this.level == 4){
            return false;
        }
        else if(this.level == 5){
            return true;
        }
        return false;
    }
}
