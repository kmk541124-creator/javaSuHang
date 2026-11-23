package entity.scene;

import entity.interact.Interact;
import entity.interact.RestCounter;
import repository.Repository;

import java.util.ArrayList;

public class RestaurantScene extends Sence{

    private ArrayList<Interact> list = new ArrayList<>();
    private final Repository repository;

    @Override
    public String getName(){
        return "식당";
    }
    @Override
    public String getSeance(){
        return """
                +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
                |'-._                                               |                                                         |                                            _.-'|
                |    '-._                                         _/_\\_                                                     _/_\\_                                      _.-'    |
                |        '-._                                      ' '                                                       ' '                                   _.-'        |
                |            '-._                                                                                                                              _.-'            |
                |                '-._                                                                                                                      _.-'                |
                |                    '-._                                                                                                              _.-'                    |
                |                        +------------------------------------------------------------------------------------------------------------+                        |
                |                        |      +-------------------+                    .-.                                                          |                        |
                |                        |      |   M  E  N  U      |                   ( | )           +--------------------------------+            |                        |
                |                        |      |  - stew .... 3    |                    '-'            |  ____    ____    ____    ____  |            |                        |
                |                        |      |  - bread ... 1    |                                   | (____)  (____)  (____)  (____) |            |                        |
                |                        |      |  - ??? ..... ?    |                                   |================================|            |                        |
                |                        |      +-------------------+                                   |                                |            |                        |
                |                        |                                                              |________________________________|            |                        |
                |                        |                                                                                                            |                        |
                |                        |____________________________________________________________________________________________________________|                        |
                |                        ||                                                                                                          ||                        |
                |                        |                                                                                                            |                        |
                |                        |                                                                                                            |                        |
                |                        +------------------------------------------------------------------------------------------------------------+                        |
                |                    _.-'      ______________________________                                        ______________________________    '-._                    |
                |                _.-'         /  [==]   [==]    o           /|                                      /     [==]   (  )   [==]      /|       '-._                |
                |            _.-'            /_____________________________/ |                                     /_____________________________/ |           '-._            |
                |        _.-'                |_____________________________|/                                      |_____________________________|/                '-._        |
                |    _.-'                     ||                         ||                                         ||                         ||                      '-._    |
                |_.-'                                                                                                                                                      '-._|
                +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
                """;
    }

    public RestaurantScene(Repository repository){
        this.repository = repository;
        list.add(new RestCounter(this, repository));
    }

    @Override
    public void reset(){
        list.clear();
        list.add(new RestCounter(this, repository));
    }

    @Override
    public void first(){
        dialogBoxService.use(this, "나", "식당같다,");
        dialogBoxService.use(this, "나", "...썩은내");
        this.first = true;
    }

    @Override
    public ArrayList<Interact> interacts(){
        return list;
    }
}
