package entity.interact;

import entity.scene.Sence;
import entity.scene.StartScene;
import item.Item;
import item.Key;
import repository.Repository;
import service.DialogBoxService;

import java.util.Scanner;

public class BedDown extends Interact{

    Scanner scanner = new Scanner(System.in);
    private DialogBoxService dialogBoxService = new DialogBoxService(scanner);
    StartScene startScene;

    public BedDown(StartScene startScene, Repository repository){
        super(startScene, repository, "침대 아래", null, null, new Key("열쇠"));
        this.startScene = startScene;
    }

    @Override
    public void showInfo(){
        dialogBoxService.use(this.startScene, "나", "단순한 배게다");
    }
}
