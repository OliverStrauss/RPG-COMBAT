package game;
public class Enemy {
    String name;
    int health;
    int attack;
   int dodge;

    // Constructor for Enemy
    public Enemy(String name, int health, int attack, int dodge) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.dodge = dodge;
    }

}