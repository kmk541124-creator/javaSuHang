package entity.interact;

import entity.scene.BreakScene;
import item.Item;
import item.Key;
import item.RestaurantKey;
import repository.Repository;

public class Ice extends Interact{

    private final Repository repository;
    private Boolean used;
    private final BreakScene breakScene;
    public Ice(BreakScene breakScene, Repository repository){
        super(breakScene, repository, "얼음", new Key("성냥"), "성냥으로 얼음을 녹였다", null);
        this.breakScene = breakScene;
        this.repository = repository;
        used = false;
    }

    @Override
    public void showInfo(){
        dialogBoxService.use(this.breakScene, "나", "얼음이다, 안에 무언가가 있는것같다");
    }

    public void reset(){
        used = false;
    }

    @Override
    public Boolean used(Item item){
        if(used){
            dialogBoxService.use(new BreakScene(repository), "나", "이미 녹았다");
        }
        if(super.used(item)){
            if(!used){
                repository.items.add(new RestaurantKey("식당 열쇠"));
                repository.items.remove(item);
                dialogBoxService.say("나", "식당 열쇠를 얻었다.");
                used = true;
                return true;
            }
            else {
                dialogBoxService.use(new BreakScene(repository), "나", "이미 녹았다");
            }
        }
        return false;
    }
}
