package item;

import controller.MoveController;
import entity.scene.Sence;

public class Item
{
    public String itemName;

    public Item(String itemName)
    {
        this.itemName = itemName;
    }

    public String NotUse()
    {
        return null;
    }

    public void Interact()
    {

    }

    public String ShowInfo()
    {
        return null;
    }

    public Boolean useCan(){
        return true;
    }

    public void use(Sence nowScene, MoveController moveController){

    };
}
