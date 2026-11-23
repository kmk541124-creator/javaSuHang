package entity.interact;

import entity.scene.RestaurantScene;
import item.Hammer;
import repository.Repository;

public class RestCounter extends Interact{
    private final RestaurantScene restaurantScene;

    public RestCounter(RestaurantScene scene, Repository repository) { super(scene, repository, "배식대", null, "놓여있는 망치를 주웠다.", new Hammer("망치")); this.restaurantScene = scene; }

    public void showInfo()
    {
        dialogBoxService.use(this.restaurantScene, "나", "배식대이다. 안에 음식은 없다.");
    }
}
