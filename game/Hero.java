package game;
public class Hero {
    String name;
    int health;
    int dodge;
    int attack;

    public Hero(String hName,int health,int dodge,int attack) {
        this.name = hName;
        this.health = 100; // Default health
        this.dodge = 10;   // Default dodge
        this.attack = 20;  // Default attack
    }
    

    public String getName() {
        return name;
    }


    public int getHealth() {
        return health;
    }


    public int getDodge() {
        return dodge;
    }


    public int getAttack() {
        return attack;
    }
    

    public void setHealth(int health) {
        this.health = health;
    }


    public void setDodge(int dodge) {
        this.dodge = dodge;
    }


    public void setAttack(int attack) {
        this.attack = attack;
    }


    @Override
    public String toString() {
        return "Hero [name=" + name + ", health=" + health + ", dodge=" + dodge + ", attack=" + attack + "]";
    }

    public int posDmg(){
        return 0;
    }




}

    


