package entity.interact;

import entity.scene.BlockedLabScene;
import entity.scene.BreakScene;
import item.CardKey;
import item.Fire;
import repository.Repository;

public class Wardrobe extends Interact{

    private BlockedLabScene blockedLabScene;
    public Wardrobe(BlockedLabScene blockedLabScene, Repository repository){
        super(blockedLabScene, repository, "부서진 옷장", null, null, new CardKey("카드키"));
        this.blockedLabScene = blockedLabScene;
    }

    @Override
    public void showInfo(){
        dialogBoxService.use(this.blockedLabScene, "나", "부서진 옷장이다");
    }
}
