package entity.interact;

import entity.scene.LabScene;
import item.CodeNum;
import repository.Repository;

public class Code extends Interact{

    private final LabScene labScene;

    public Code(LabScene scene, Repository repository) { super(scene, repository, "쪽지", null, "벽에 붙은 쪽지를 본다.", new CodeNum("코드")); this.labScene = scene; }

    public void showInfo()
    {
        dialogBoxService.use(this.labScene, "나", "벽에 붙은 쪽지. 숫자가 적혀져 있다.");
    }
}
