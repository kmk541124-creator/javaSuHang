package item;

public class CodeNum extends Item{
    public String itemName;

    public CodeNum(String itemName) { super(itemName); }

    @Override
    public String ShowInfo(){
        return "숫자 4자리";
    }

    @Override
    public String NotUse(){
        return "실험실의 코드로 보인다.";
    }

    @Override
    public Boolean useCan(){
        return false;
    }
}
