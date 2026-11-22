package entity.scene;

import entity.interact.BedDown;
import entity.interact.Door;
import entity.interact.Interact;
import repository.Repository;
import service.DialogBoxService;

import java.util.ArrayList;
import java.util.Scanner;

public class StartScene extends Sence{

    public Boolean doorOpen = false;
    private Scanner scanner = new Scanner(System.in);
    private DialogBoxService dialogBoxService = new DialogBoxService(scanner);
    private ArrayList<Interact> list = new ArrayList<>();
    private Repository repository;
    Door door;

    public StartScene(Repository repository){
        doorOpen = false;
        list.add(new BedDown(this, repository));
        list.add(new Door(this, repository));
        door = new Door(this, repository);
        this.repository = repository;
    }

    @Override
    public void reset(){
        doorOpen = false;
        list.clear();
        list.add(new BedDown(this, repository));
        list.add(new Door(this, repository));
        door = new Door(this, repository);
    }

    @Override
    public String getName(){
        return "독방";
    }

    @Override
    public String getSeance(){
        return """
            +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
            |'-._                                                                           |                                                                          _.-'|
            |    '-._                                                                       |                                                                      _.-'    |
            |        '-._                                                                  _|_                                                                 _.-'        |
            |            '-._                                                             (   )                                                            _.-'            |
            |                '-._                                                          '-'                                                         _.-'                |
            |                    '-._                                                    .  '  .                                                   _.-'                    |
            |                        +------------------------------------------------------------------------------------------------------------+                        |
            |                        |                                         O                                                                  |                        |
            |                        |          +--------------+               8                              +------------------------+          |                        |
            |                        |          |  |  |  |  |  |               8                              |  +------------------+  |          |                        |
            |                        |          |  |  |  |  |  |               8                              |  | |  |  |  |  |  | |  |          |                        |
            |                        |          |  |  |  |  |  |              (_)                             |  | |  |  |  |  |  | |  |          |                        |
            |                        |          +--------------+                                              |  +------------------+  |          |                        |
            |                        |                                                                        |                        |          |                        |
            |                        |          ||||  ||||  ||||  ||||  |||                                   |[]                 (o)  |          |                        |
            |                        |                                                                        |                    |   |          |                        |
            |                        |            CELL NO.0                                                   |[]                      |          |                        |
            |                        |                                                                        |                        |          |                        |
            |                        |                                                                        |________________________|          |                        |
            |                        +------------------------------------------------------------------------------------------------------------+                        |
            |                    _.-'     __________________________________.  .  .                                           .-------.            '-._                    |
            |                _.-'        /                                 /|  .  .  .                                       (         )               '-._                |
            |            _.-'           /_________________________________/ |     .  .  .             .---------------.       |       |                    '-._            |
            |        _.-'               |_________________________________|/                          | # # # # # # # |       |       |                        '-._        |
            |    _.-'                    ||                             ||                            '---------------'       '-------'                            '-._    |
            |_.-'                                                                                                                                                      '-._|
            +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
            """;
    }

    @Override
    public Boolean move() {
        if (doorOpen) {
            return true;
        } else {
            dialogBoxService.showArt(getSeance());
            dialogBoxService.say("나", "'문이 잠겨있어 갈 수 없다'");
            dialogBoxService.close();
            return false;
        }
    }

    @Override
    public ArrayList<Interact> interacts(){
        return list;
    }
    public void open(){
        doorOpen = true;
    }
}
