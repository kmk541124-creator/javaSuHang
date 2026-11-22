package item;

import service.DialogBoxService;

import java.util.Scanner;

public class Key extends Item{

    public String itemName;
    public Key(String itemName){
        super(itemName);
        this.itemName = itemName;
    }

    @Override
    public String ShowInfo(){
        return "단순한 녹슨 열쇠";
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
