public class Monster {
    private int hp;
    private int maxHp;
    private int expReward;
    private int goldReward;
    private int level;
    private int damage;
    public Monster(){
        this.maxHp = 100;
        this.hp = maxHp;
        this.level = 1;
        this.expReward = 25;
        this.goldReward =25;
        this.damage = level * 5;

    }
    public void takeDamage(int amount){
        if (amount < 0){
            System.out.println("Damage can't be negative");
            return;
        }
        hp = Math.max(0, hp - amount);
    }
    public boolean isAlive() {
        return hp > 0;
    }
    public void attack(Hero target ){
        if(!target.isAlive()|| !isAlive()) return;
        target.takeDamage(damage);
        System.out.println("Монстр ударил на " + damage + " урона");
    }
}