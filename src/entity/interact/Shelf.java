package entity.interact;

import entity.scene.BreakScene;
import item.Fire;
import item.Key;
import repository.Repository;

public class Shelf extends Interact{

    private BreakScene breakScene;
    public Shelf(BreakScene breakScene, Repository repository){
        super(breakScene, repository, "선반", null, null, new Fire("성냥"));
        this.breakScene = breakScene;
    }

    @Override
    public void showInfo(){
        dialogBoxService.use(this.breakScene, "나", "먼지가 쌓인 선반이다");
    }
}
