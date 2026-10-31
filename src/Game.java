import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    int roomLevel = 0;
    public void start(){

        System.out.println("Enter heros name");
        String name = scan.nextLine();
        Hero hero = new Hero(name);
        boolean isPlay = true;

        while (isPlay && hero.isAlive()) {
            showMenu();
            int action = selectAction();
            switch (action){
                case 1:
                    createRoom();
                    break;
                case 2:
                    showInfo(hero);
                    break;
                case 0:
                    isPlay = false;
                    break;
            }
        }
        System.out.println("Good Bye");
    }
    public int selectAction(){
        return scan.nextInt();
    }
    public void showMenu() {
        System.out.println("1 - go");
        System.out.println("2 - status");
        System.out.println("0 - exit");
    }
    public void createRoom() {
        Random random = new Random();

        roomLevel++;

        int randType = random.nextInt(3) + 1;
        int numberEntity = roomLevel + random.nextInt(3);

        Room room = new Room(randType, roomLevel, numberEntity);

        System.out.println("Room #" + roomLevel);
        System.out.println("Type: " + room.typeRoom());
        System.out.println("Level: " + room.level);
        System.out.println("Entities: " + room.numberEntity);
    }
    public void showInfo(Hero hero){
        System.out.println(hero.toString());
    }
}
