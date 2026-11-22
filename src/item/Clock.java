package item;

import controller.MoveController;
import entity.scene.Sence;

public class Clock extends Item{
    public Clock(String itemName){
        super(itemName);
    }

    @Override
    public String ShowInfo(){
        return "11시 25분을 가르키는 회중시계, 뒷면에는 MEMENTO MORI라는 글씨가 적혀있다";
    }

    @Override
    public void use(Sence nowScene, MoveController moveController){
        moveController.reset();
    }
}
