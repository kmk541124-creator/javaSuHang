package repository;

import entity.scene.*;
import item.Item;

import java.util.ArrayList;

public class Repository {
    public ArrayList<Sence> locations = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();

    public Repository(){
        locations.add(new StartScene(this));
        locations.add(new HallScene());
        locations.add(new RestaurantScene());
        locations.add(new BreakScene());
        locations.add(new BlockedLabScene());
        locations.add(new LabScene());
        locations.add(new ApexScene());
        locations.add(new MoonScene());
    }
}
