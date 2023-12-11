package game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy {
    String name;
    int health;

    int dodge;
    boolean alive;

    // Constructor for Enemy
    public Enemy() {
        this.name = "Enemy";
        this.health = genEHealth();
        this.dodge = genEDodge();
        this.alive = true;
    }

    public int genEHealth(){
        return 10;
    }


    public int genEDodge(){
        return 10;

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }



    public int getDodge() {
        return dodge;
    }


    public void setDead(){
        this.alive = false;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public boolean gotHit(int dodge,double roll){


        List<Map> MapList = Map.dodgeChance();
        double playerChance = 0.0;
        for (Map r : MapList) {
            if (r.contains(dodge)) {
                 playerChance = r.val;
            }
        }
        return roll > playerChance;
    }
    public double CalcDmg(int HArmor){
        List<Map> HealthList = Map.healthModifier();
        double playerChance = 0.0;
        for (Map r : HealthList) {
            if (r.contains(HArmor)) {
                playerChance = r.val;
            }
        }

    return playerChance;
    }
    public double getDmg(){

        return  5;
    }
    public void printHeroHit(Hero h, int dmgTaken){
        System.out.println("The "+this.name +" has struck "+ h.name+" for "+dmgTaken +" damage! ");
    }


    public void AttackHero(Hero h){
        Random rand = new Random();
        double eRoll =Main.RollToPercent(Main.roll(this.name));
        Main.pauseGame(2000);

        int hArmor = h.getArmor();
        int hDodge = h.getDodge();
        double dmg = getDmg();

        int dmgTaken = (int)Math.floor(dmg - (dmg*CalcDmg(hArmor)));
        if(gotHit(hDodge,eRoll)){
            h.setHealth(h.getHealth()-(dmgTaken));
            printHeroHit(h,dmgTaken);

            h.displayHealth();
        }
        else{
            Main.pauseGame(2000);
            System.out.println(h.name+ "has miraculously dodged the attack!");
        }
    }



    @Override
    public String toString(){
        return "Enemy{" +
                "name='" + this.name + '\'' +
                ", health=" + this.health +
                ", dodge=" + this.dodge +
                '}';
    }
}