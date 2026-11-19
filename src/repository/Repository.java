package repository;

import java.util.ArrayList;

public class Repository {
    public ArrayList<String> locations = new ArrayList<>();
    public Repository(){
        locations.add("start");
        locations.add("hall");
        locations.add("restaurant");
        locations.add("break");
        locations.add("blockedLab");
        locations.add("lab");
        locations.add("apex");
        locations.add("moon");
    }
}
