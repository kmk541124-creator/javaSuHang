package entity.scene;

import entity.interact.Code;
import entity.interact.Interact;
import entity.interact.RestCounter;
import item.CodeNum;
import repository.Repository;

import java.util.ArrayList;

public class LabScene extends Sence{

    private ArrayList<Interact> list = new ArrayList<>();
    private final Repository repository;

    @Override
    public String getName(){
        return "연구실";
    }
    @Override
    public String getSeance(){
        return """
                +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
                |'-._                                             |                                                           |                                            _.-'|
                |    '-._                                       _/_\\_                                                       _/_\\_                                      _.-'    |
                |        '-._                                    ' '                                                         ' '                                   _.-'        |
                |            '-._                                                                                                                              _.-'            |
                |                '-._                                                                                                                      _.-'                |
                |                    '-._                                                                                                              _.-'                    |
                |                        +------------------------------------------------------------------------------------------------------------+                        |
                |                        |    +-----------------------------+                                                                         |                        |
                |                        |    |  f(x) = ax^2 + bx + c       |                 +--------+ +--------+ +--------+                        |                        |
                |                        |    |                             |                 | >_     | | ~~~~   | | 0101   |                        |                        |
                |                        |    |     /\\      __              |                 | ...    | |  /\\/\\  | | 1100   |                        |                        |
                |                        |    |    /  \\    |  |  -->  ?     |                 +--------+ +--------+ +--------+                        |                        |
                |                        |    |___/____\\___|__|_____________|                      ||         ||         ||                           |                        |
                |                        |                                                  ____________________________________                      |                        |
                |                        |                                                  |                                  |                      |                        |
                |                        |                                                                                                            |                        |
                |                        |                                                                                                            |                        |
                |                        |                                                                                                            |                        |
                |                        |                                                                                                            |                        |
                |                        +------------------------------------------------------------------------------------------------------------+                        |
                |                    _.-'        ____________________________________________                            ________                      '-._                    |
                |                _.-'           /  |_|    |_|     _     |_|                 /|                          /       /|                         '-._                |
                |            _.-'              /___________________________________________/ |                         /_______/ |                             '-._            |
                |        _.-'                  |___________________________________________|/                          |  ___  | |                                 '-._        |
                |    _.-'                       ||                                       ||                            | |___| |/                                      '-._    |
                |_.-'                                                                                                  |_______|                                           '-._|
                +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
                """;
    }

    public LabScene(Repository repository){
        this.repository = repository;
        list.add(new Code(this, repository));
    }

    @Override
    public void reset(){
        list.clear();
        list.add(new Code(this, repository));
    }

    @Override
    public ArrayList<Interact> interacts(){
        return list;
    }
}
