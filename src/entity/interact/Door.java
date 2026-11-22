package entity.interact;

import entity.scene.StartScene;
import item.Item;
import item.Key;
import repository.Repository;
import service.DialogBoxService;

import java.util.Scanner;

public class Door extends Interact{

    private Scanner scanner = new Scanner(System.in);
    private DialogBoxService dialogBoxService = new DialogBoxService(scanner);

    private StartScene startScene;
    public Door(StartScene startScene, Repository repository){
        super(startScene, repository, "문", new Key("열쇠"), "열쇠를 사용했다", null);
        this.startScene = startScene;
    }

    @Override
    public void showInfo(){
        dialogBoxService.use(this.startScene, "나", "녹슨 문이다");
    }

    @Override
    public Boolean used(Item item){
        if(super.used(item)){
            startScene.open();
            return true;
        }
        return false;
    }
}
