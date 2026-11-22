package repository;

import entity.scene.*;
import item.Item;

import java.util.ArrayList;

public class Repository {
    public ArrayList<Sence> locations = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();
    public ArrayList<String> startString = new ArrayList<>();
    public ArrayList<String> startOther = new ArrayList<>();
    public ArrayList<String> attackString = new ArrayList<>();
    public ArrayList<String> secondString = new ArrayList<>();
    public ArrayList<String> firstReset = new ArrayList<>();
    public ArrayList<String> secondRest = new ArrayList<>();

    public Repository(){
        locations.add(new StartScene(this));
        locations.add(new HallScene());
        locations.add(new RestaurantScene());
        locations.add(new BreakScene());
        locations.add(new BlockedLabScene());
        locations.add(new LabScene());
        locations.add(new ApexScene());
        locations.add(new MoonScene());

        startString.add("여긴 어딜까");
        startString.add("눈을 떠보니 이곳이였다");
        startString.add("...곰팡이 냄새");
        startString.add("누가, 언제, 왜, 날 이곳에 가둔건지 모른다");
        startString.add("...? 눈앞에 시계가 하나 있다");
        startString.add("'시계를 획득했다'");
        startString.add("11시 25분을 가르키고 있다");
        startString.add("초침은 없고");
        startString.add("움직이진 않는다");
        startString.add("시계 뒷면에는 글씨가 적혀있다");
        startString.add("\"MEMENTO MORI\"");
        startOther.add("...?");

        startOther.add("다...");
        startOther.add("다 니 때문이잖아...!");

        attackString.add("배가 뜨거워 진다");
        attackString.add("쓰러진 줄 알았던 사람 한명이 내 배를 찔렀다");
        attackString.add("이것조차 눈기 감기기 직전 간신히 보인 것이다");
        attackString.add("저자는 나의 피가 떨어지는 무언가를 들고 씩씩 대며 날 보고있다");
        attackString.add("다리가 풀린다");
        attackString.add("쓰러지기 직전 내 손에 들려있던 회중시계의 버튼을 누른다");
        attackString.add("시야가 암전된다");

        secondString.add("...");
        secondString.add("...?");
        secondString.add("...뭐지 꿈이였나");
        secondString.add("배를 만져본다 멀쩡하다");
        secondString.add("내 눈앞에는...");
        secondString.add("내가 처음 이곳에 눈을 떴을때의...");
        secondString.add("순간적으로 깨닫고 방향을 튼다");
        secondString.add("아까전에 그 자가 나를 향해 달려오던 참이였다");
        secondString.add("간신히 피했다");
        secondString.add("주변에 있던 짱돌을 줍는다");
        secondString.add("자기 속도를 주체 하지 못하고 거리가 생긴 그의 머리를 향해");
        secondString.add("내려찍는다");
        secondString.add("그가 바닥에 털썩 쓰러진다");
        secondString.add("숨을 고르며며 그를 내려다 본다");
        secondString.add("가운, 명찰, 의사와 비슷하지만 얼핏 연구원에 가까워 보인다");
        secondString.add("그의 주머니를 뒤져본다 이곳의 지도를 얻었다");
        secondString.add("...");
        secondString.add("제대로 볼 수도 없다");
        secondString.add("우선 이곳을 나간뒤에 제대로된 지도를 얻던가 해야겠다");

        firstReset.add("...!");
        firstReset.add("뭐야");
        firstReset.add("또 돌아왔다");
        firstReset.add("똑같다");
        firstReset.add("처음 찔려서 돌아올때랑,");
        firstReset.add("똑같이 돌아왔다");
        firstReset.add("지도는... 그대로 있다");
        firstReset.add("소지품은 유지되는건가");

        secondRest.add("...");
        secondRest.add("이제 확실해졌다");
        secondRest.add("돌아왔다");
        secondRest.add("내가 죽으면 시계는 작동된다");
        secondRest.add("내가 의도적으로 작동시켜도 돌아온다");
        secondRest.add("지도는 여전히 내 주머니에있다");
        secondRest.add("소지품은 유지,");
        secondRest.add("시점은 이곳에서 지도를 얻고 나서,");
        secondRest.add("MEMENTO MORI,");
        secondRest.add("꺼림칙하긴 했지만");
        secondRest.add("확실해졌다");
        secondRest.add("\"죽음을 기억하라.\"");
        secondRest.add("\"죽어야 한다.\"");
        secondRest.add("...");
        secondRest.add("개 같네...");
    }

}
