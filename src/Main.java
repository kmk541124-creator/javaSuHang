import controller.MoveController;
import repository.ArtRepository;
import repository.Repository;

void main() {
    Repository repository = new Repository();
    ArtRepository artRepository = new ArtRepository();
    MoveController moveController = new MoveController();
    while (true){
        moveController.Print();
    }
}