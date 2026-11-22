import controller.MoveController;
import entity.scene.Black;
import entity.scene.StartScene;
import item.Clock;
import item.Item;
import item.Key;
import repository.ArtRepository;
import repository.Repository;
import service.DialogBoxService;

void main() {
    Repository repository = new Repository();
    ArtRepository artRepository = new ArtRepository();
    MoveController moveController = new MoveController(repository);
    Scanner sc = new Scanner(System.in);
    DialogBoxService dialogBoxService = new DialogBoxService(sc);
    StartScene startScene = new StartScene(repository);
    Item item = new Clock("시계");

    for(String string : repository.startString){
        dialogBoxService.use(startScene, "나", string);
    }

    dialogBoxService.use(startScene, "???", repository.startOther.get(0));
    dialogBoxService.use(startScene, "???", repository.startOther.get(1));

    dialogBoxService.use(startScene, "나", "...!");
    for(String string : repository.attackString){
        dialogBoxService.use(startScene, "나", string);
    }
    dialogBoxService.use(new Black(), "나", "...");
    for(String string : repository.secondString){
        dialogBoxService.use(startScene, "나", string);
    }

    repository.items.add(item);
    while (true){
        moveController.Init();
    }
}