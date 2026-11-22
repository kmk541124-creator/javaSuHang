package entity.scene;

public class RestaurantScene extends Sence{
    @Override
    public String getName(){
        return "식당";
    }
    @Override
    public String getSeance(){
        return "임시";
    }

    @Override
    public void first(){
        dialogBoxService.use(this, "나", "식당같다,");
        dialogBoxService.use(this, "나", "...썩은내");
        this.first = true;
    }
}
