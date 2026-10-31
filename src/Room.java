public class Room {
    int type;
    int level;
    int numberEntity;
    public Room(int type, int level, int numberEntity){
        this.type = type;
        this.level = level;
        this.numberEntity = numberEntity;
    }
    public String typeRoom() {
        switch (this.type) {
            case 1:
                return "Fight";
            case 2:
                return "Treasure";
            case 3:
                return "Rest";
            default:
                return "Unknown";
        }
    }
}
