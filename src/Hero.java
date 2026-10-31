public class Hero {
    private final String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int gold;
    private int level;
    private int exp;

    public Hero(String name) {
        this.name = name;
        this.maxHp = 100;
        this.hp = maxHp;
        this.attack = 10;
        this.gold = 0;
        this.level = 1;
        this.exp = 0;
    }
    public boolean isAlive() {
        return hp > 0;
    }
    public void takeDamage(int damage){
        if (damage < 0){
            System.out.println("Damage can't be negative");
            return;
        }
        hp = Math.max(0, hp - damage);
    }
    public void heal (int heal){
        if(heal < 0){
            System.out.println("Heal can't be negative");
        }
        if(!isAlive()){
            System.out.println("You are died");
        }
        hp = Math.min(maxHp,hp + heal);
    }
    public void addGold(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Нельзя добавить отрицательное золото");
        }
        gold += amount;
    }
    public boolean spendGold(int amount) {
        if (amount < 0 || amount > gold) {
            return false;                        // золота не хватает
        }
        gold -= amount;
        return true;
    }

    private  int expToNextLevel(){
        return level *100;
    }
    private void levelUp(){
        level++;
        maxHp += 20;
        attack += 3;
        hp = maxHp;
        System.out.println("Новый уровень: " + level + "!");
    }

    private void gainExp(int amount){
        if (amount < 0) {
            throw new IllegalArgumentException("Опыт не может быть отрицательным");
        }
        exp += amount;

        // while, а не if: за один бой можно получить сразу несколько уровней
        while (exp >= expToNextLevel()) {
            exp -= expToNextLevel();
            levelUp();
        }
    }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getGold() { return gold; }
    public int getLevel() { return level; }
    public int getExp() { return exp; }

    @Override
    public String toString() {
        return name + " [HP " + hp + "/" + maxHp + " | ATK " + attack
                + " | LVL " + level + " | EXP " + exp + "/" + expToNextLevel() + "]";}
}
