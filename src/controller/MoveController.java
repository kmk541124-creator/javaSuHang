package controller;


import entity.interact.Interact;
import entity.scene.HallScene;
import entity.scene.RestaurantScene;
import entity.scene.Sence;
import item.Item;
import repository.ArtRepository;
import repository.Repository;
import service.service;
import service.DialogBoxService;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveController {

    public int location = 0;
    private Boolean script = false;
    private int retry = 0;
    Scanner scanner = new Scanner(System.in);

    private ArtRepository artRepository;
    private final Repository repository;
    public MoveController(Repository repository){
        this.repository = repository;
        this.script = false;
    }
    private service service;
    private final DialogBoxService dialogBoxService = new DialogBoxService(scanner);



    public void Move(int wantNext){
        if(wantNext == this.location) return;
        if(location == 1)
        {
            switch(wantNext)
            {
                case 2:
                    if(!((HallScene)repository.locations.get(this.location)).openRest)
                    {
                        dialogBoxService.say("나", "잠겨있다.");
                        if(!repository.items.isEmpty()){
                            dialogBoxService.say("나", "물건을 사용할까");
                            System.out.print("Y or N: ");
                            String pick = scanner.nextLine();
                            if(pick.equals("Y") || pick.equals("y")){
                                pick = dialogBoxService.showItem("가방",repository.items);
                                if (isNumber(pick) && Integer.parseInt(pick) < repository.items.size()) {
                                    if(repository.items.get(Integer.parseInt(pick)).itemName.equals("식당 열쇠")){
                                        repository.locations.get(1).openRest();
                                    } else {
                                        dialogBoxService.say("나","이건 사용할 수 없다");
                                    }
                                    return;
                                } else {
                                    dialogBoxService.say("나", "'그런 곳은 없다'");
                                    return;
                                }
                            } else{
                                return;
                            }
                        }
                    }
                case 3:
                    break;
                case 4:
                    if(!((HallScene)repository.locations.get(this.location)).openBlock)
                    {
                        dialogBoxService.say("나", "판자로 막혀있다.");
                        if(!repository.items.isEmpty()){
                            dialogBoxService.say("나", "물건을 사용할까");
                            System.out.print("Y or N: ");
                            String pick = scanner.nextLine();
                            if(pick.equals("Y") || pick.equals("y")){
                                pick = dialogBoxService.showItem("가방",repository.items);
                                if (isNumber(pick) && Integer.parseInt(pick) < repository.items.size()) {
                                    if(repository.items.get(Integer.parseInt(pick)).itemName.equals("망치"))
                                        repository.locations.get(1).openBlock();
                                    else
                                        System.out.println("망치 아님 꺼지셈");
                                    return;
                                } else {
                                    dialogBoxService.say("나", "'그런 곳은 없다'");
                                    return;
                                }
                            } else{
                                return;
                            }
                        }
                    }
                case 5:
                    if(!((HallScene)repository.locations.get(this.location)).openLab)
                    {
                        dialogBoxService.say("나", "잠겨있다.");
                        if(!repository.items.isEmpty()){
                            dialogBoxService.say("나", "물건을 사용할까");
                            System.out.print("Y or N: ");
                            String pick = scanner.nextLine();
                            if(pick.equals("Y") || pick.equals("y")){
                                pick = dialogBoxService.showItem("가방",repository.items);
                                if (isNumber(pick) && Integer.parseInt(pick) < repository.items.size()) {
                                    if(repository.items.get(Integer.parseInt(pick)).itemName.equals("카드키")){
                                        if(repository.items.get(Integer.parseInt(pick)).Interact()){
                                            repository.locations.get(1).openLab();
                                            return;
                                        } else {
                                            dialogBoxService.say("나","권한이 부족하다");
                                            return;
                                        }

                                    } else {
                                        dialogBoxService.say("나","이건 사용할 수 없다");
                                        return;
                                    }
                                } else {
                                    dialogBoxService.say("나", "'그런 곳은 없다'");
                                    return;
                                }
                            } else{
                                return;
                            }
                        }
                        return;
                    }
                case 6:
                    if(!((HallScene)repository.locations.get(this.location)).openApex)
                    {
                        dialogBoxService.say("나", "비밀번호로 잠겨있다.");
                        return;
                    }
            }
        }
        location = service.Move(location, wantNext);
        Sence nextScene = repository.locations.get(location);
        if(!nextScene.first){
            nextScene.first();
            nextScene.dialogBoxService.skipping = false;
        }
        Print();
    }

    public void Init(){
        this.artRepository = new ArtRepository();
        this.service = new service(repository);
        Print();
    }

    public void reset(){
        retry++;
        this.script = false;
        location = 0;
        this.artRepository = new ArtRepository();
        this.service = new service(repository);
        for(Sence sence : repository.locations){
            sence.reset();
        }
        Print();
    }

    public void OpenMap(){
        System.out.print("\033[H\033[2J\033[3J");
        if(location == 0){
            System.out.println(artRepository.BeforeMap);
        } else {
            System.out.println(artRepository.AfterMap);
        }

        System.out.println();
        System.out.println("나가기: 3");
        String next =  scanner.nextLine();
        if(next.equals("3")){
            Print();
        }
    }

    public void Print(){
        Sence nowScene = repository.locations.get(location);
        if(nowScene.getName().equals("독방") && !script){
            switch (retry){
                case 1 -> {
                    for(String string : repository.firstReset){
                        dialogBoxService.use(nowScene,"나",string);
                    }
                }
                case 2 -> {
                    for(String string : repository.secondRest){
                        dialogBoxService.use(nowScene,"나",string);
                    }
                }
            }
            script = true;
        }
        dialogBoxService.showArt(nowScene.getSeance());
        System.out.println("현재 위치: " + nowScene.getName());
        System.out.println("어디로 가시겠습니까");
        System.out.print("입력(번호: 이동,M: 지도 열기, F: 수색, U: 조사, B: 가방): ");
        String next = scanner.nextLine();
        switch (next) {
            case "M", "m" -> OpenMap();
            case "F", "f" -> {
                ArrayList<Interact> places = nowScene.interacts();
                if (places == null || places.isEmpty()) {
                    dialogBoxService.use(nowScene, "나", "'딱히 수색할 곳이 없다'");
                    return;
                }
                dialogBoxService.use(nowScene, "나", "'어디를 수색할까'");
                String pick = dialogBoxService.showInter("수색할 곳", places);
                if (isNumber(pick) && Integer.parseInt(pick) < places.size()) {
                    places.get(Integer.parseInt(pick)).find();
                } else {
                    dialogBoxService.use(nowScene, "나", "'그런 곳은 없다'");
                }
            }
            case "U", "u" -> {
                ArrayList<Interact> places = nowScene.interacts();
                if (places == null || places.isEmpty()) {
                    dialogBoxService.use(nowScene, "나", "'딱히 조사할 곳이 없다'");
                    return;
                }
                dialogBoxService.use(nowScene, "나", "'어디를 조사할까'");
                String pick = dialogBoxService.showInter("조사할 곳", places);
                if (!isNumber(pick) || Integer.parseInt(pick) >= places.size()) {
                    dialogBoxService.use(nowScene, "나", "'그런 곳은 없다'");
                    return;
                }
                Interact nowPlace = places.get(Integer.parseInt(pick));
                nowPlace.showInfo();
                if(!repository.items.isEmpty()){
                    dialogBoxService.say("나", "물건을 사용할까");
                    System.out.print("Y or N: ");
                    pick = scanner.nextLine();
                    if(pick.equals("Y") || pick.equals("y")){
                        pick = dialogBoxService.showItem("가방",repository.items);
                        if (isNumber(pick) && Integer.parseInt(pick) < repository.items.size()) {
                            nowPlace.used(repository.items.get(Integer.parseInt(pick)));
                        } else {
                            dialogBoxService.say("나", "'그런 곳은 없다'");
                        }
                    }
                }
            }
            case "B", "b" -> {
                dialogBoxService.showArt(nowScene.getSeance());
                String pickk = dialogBoxService.showItem("가방", repository.items);
                if(isNumber(pickk) && Integer.parseInt(pickk) < repository.items.size()){
                    System.out.print("무엇을 할까(1: 사용, 2: 조사, 3:나가기): ");
                    String pick = scanner.nextLine();
                    if(isNumber(pick) && Integer.parseInt(pick) >= 1 && Integer.parseInt(pick) <= 3){
                        Item item = repository.items.get(Integer.parseInt(pickk));
                        switch (Integer.parseInt(pick)){
                            case 1 -> {
                                if(item.useCan()){
                                    item.use(nowScene, this);
                                } else{
                                    String useInfo = repository.items.get(Integer.parseInt(pickk)).NotUse();
                                    dialogBoxService.use(nowScene, "나", useInfo);
                                }
                            } case 2 -> {
                                String findInfo = repository.items.get(Integer.parseInt(pickk)).ShowInfo();
                                dialogBoxService.use(nowScene, "나", findInfo);
                            }
                        }
                    } else{
                        dialogBoxService.use(nowScene, "나","...?");
                    }
                } else{
                    dialogBoxService.use(nowScene, "나", "그런 아이템은 없다");
                }
            }
            default -> {
                if (isNumber(next)) {
                    if (nowScene.move()) {
                        Move(Integer.parseInt(next));
                    }
                } else {
                    System.out.println("다시 입력해");
                    Print();
                }
            }
        }
    }

    private boolean isNumber(String text) {
        if (text.isEmpty() || text.length() > 9) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }
}
