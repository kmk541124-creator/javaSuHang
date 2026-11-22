package entity.interact;

import entity.scene.Sence;
import item.Item;
import repository.Repository;
import service.DialogBoxService;

import java.util.Scanner;

public class Interact {

    private Scanner scanner = new Scanner(System.in);
    private DialogBoxService dialogBoxService = new DialogBoxService(scanner);
    public Sence place;
    public String name;
    public Item useItem;
    public Item haveItem;
    private Repository repository;
    private String info;

    private String useSay;

    public Interact(Sence place, Repository repository, String name, Item useItem, String useSay, Item haveItem){
        this.place = place;
        this.repository = repository;
        this.name = name;
        this.useItem = useItem;
        this.useSay = useSay;
        this.haveItem = haveItem;
    }

    public Boolean used(Item item){
        if(item.itemName.equals(useItem.itemName)){
            dialogBoxService.showArt(place.getSeance());
            dialogBoxService.say("나", useSay);
            dialogBoxService.close();
            return true;
        } else {
            dialogBoxService.use(place, "나","딱히 사용할순 없을것 같다");
            return false;
        }
    }

    public void find(){
        if(this.haveItem == null){
            dialogBoxService.use(place, "나", "아무것도 찾을 수 없었다");
            return;
        }
        dialogBoxService.use(place, "나", haveItem.itemName + "를 찾았다");
        repository.items.add(haveItem);
        this.haveItem = null;
    }

    public void showInfo(){
    }
}
