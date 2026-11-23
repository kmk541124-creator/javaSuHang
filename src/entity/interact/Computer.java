package entity.interact;

import entity.scene.BlockedLabScene;
import item.CardKey;
import item.Fire;
import item.Item;
import repository.Repository;

import javax.smartcardio.Card;

public class Computer extends Interact{

    private BlockedLabScene blockedLabScene;

    public Computer(BlockedLabScene blockedLabScene, Repository repository){
        super(blockedLabScene, repository, "컴퓨터", new CardKey("카드키"), null, null);
        this.blockedLabScene = blockedLabScene;
    }

    @Override
    public Boolean used(Item item){
        if(item.itemName.equals(useItem.itemName)){
            if (item instanceof CardKey) {
                ((CardKey) item).levelUp();
                dialogBoxService.use(blockedLabScene, "컴퓨터", "권한 업데이트");
                dialogBoxService.use(blockedLabScene, "나", "컴퓨터 전원이 꺼졌다");
            }
            return false;
        } else {
            dialogBoxService.use(place, "나","딱히 사용할순 없을것 같다");
            return false;
        }
    }

    @Override
    public void showInfo(){
        dialogBoxService.use(this.blockedLabScene, "나", "단순한 컴퓨터, 카드키를 삽입할 수 있는 구멍이있다");
    }
}
