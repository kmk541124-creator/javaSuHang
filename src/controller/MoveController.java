package controller;


import entity.interact.Interact;
import entity.scene.Sence;
import repository.ArtRepository;
import repository.Repository;
import service.service;
import service.DialogBoxService;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveController {

    public int location = 0;
    Scanner scanner = new Scanner(System.in);

    private ArtRepository artRepository = new ArtRepository();
    private Repository repository = new Repository();
    private service service = new service(repository);
    private DialogBoxService dialogBoxService = new DialogBoxService(scanner);

    public void Move(int wantNext){
        location = service.Move(location, wantNext);
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
        dialogBoxService.showArt(nowScene.getSeance());
        System.out.println("현재 위치: " + nowScene.getName());
        System.out.println("어디로 가시겠습니까");
        System.out.print("입력(M: 지도 열기, F: 수색, U: 조사): ");
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
                dialogBoxService.showInter("수색할곳", places);
                System.out.print("번호 입력: ");
                String pick = scanner.nextLine();
                try {
                    places.get(Integer.parseInt(pick)).find();
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
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
                dialogBoxService.showInter("조사할곳", places);
                System.out.print("번호 입력: ");
                String pick = scanner.nextLine();
                try {
                    Interact nowPlace = places.get(Integer.parseInt(pick));
                    nowPlace.showInfo();
                    if(!repository.items.isEmpty()){
                        dialogBoxService.use(nowScene, "나", "물건을 사용할까");
                        System.out.print("Y or N: ");
                        pick = scanner.nextLine();
                        if(pick.equals("Y") || pick.equals("y")){
                            dialogBoxService.showItem("가방",repository.items);
                            System.out.print("번호입력: ");
                            pick = scanner.nextLine();
                            nowPlace.used(repository.items.get(Integer.parseInt(pick)));
                        }
                    }
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    dialogBoxService.use(nowScene, "나", "'그런 곳은 없다'");
                }
            }
            default -> {
                try {
                    if (nowScene.move()) {
                        Move(Integer.parseInt(next));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("다시 입력해");
                    Print();
                }
            }
        }

    }
}
