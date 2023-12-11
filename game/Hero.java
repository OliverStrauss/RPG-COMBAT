package game;

import java.util.List;
import java.util.Random;

public class Hero {
    String name;
    int health;
    int dodge;

    int armor;
    int attack;

    public Hero(String hName) {
        this.name = hName;
        this.health = genHealth();
        this.dodge = genDodge();
        this.armor = genArmor();   // Default dodge
        this.attack = genAttack();  // Default attack
    }
    public int genHealth(){
        Random rand = new Random();
        return  rand.nextInt(90,100);
    }
     public int genDodge(){
        Random rand = new Random();
        return  rand.nextInt(14,20);

    }
    public int genArmor(){
        Random rand = new Random();
        return  rand.nextInt(14,20);
    }
    public int genAttack(){
        Random rand = new Random();
        return  rand.nextInt(14,20);
    }
    

    public String getName() {
        return name;
    }


    public int getHealth() {
        return health;
    }
    public int getArmor() {
        return armor;
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

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void displayHealth(){
        System.out.println(this.name+" now has "+ this.getHealth() + " HP!");
    }

    public String ChooseClassAction(){
        return "True";
    }
    public int CalcChoice(String choice){
        return 0;
    }
    public boolean isCombat(String choice){
        return true;
    }
    public int AttackModifer(){
        List<Map> AttackList = Map.strengthModifer();
        int attackMod =0;
        for (Map r : AttackList) {
            if (r.contains(this.getAttack())) {
                attackMod = (int) r.val;
            }
        }
        return attackMod;

    }

    public void AttackEnemy(Enemy e,int dmg,String classAction){
        e.setHealth(e.getHealth()-dmg);
        System.out.println(this.name+" Has Struck a "+ e.name+ " with a " + classAction + " for "+ dmg + " damage!");

    }
    public static void dodged(Enemy e,String action){
        System.out.println("The " + e.name + " dodged the Attack! " );

    }
    public String ConvertAction(String action){
        return "";
    }

    public void checkAlive(Enemy e,String action){
        if(e.getHealth()<0){
            System.out.println("The " + action + " has killed the " + e.getName() + "!");
        }
        e.setDead();
    }

    public void PlayerTurn(Enemy e){
        int EDodge = e.getDodge();

        String pAction = ChooseClassAction();
        String actionName = ConvertAction(pAction);

        boolean isCombat = isCombat(pAction);

        double PlayerRoll = Main.RollToPercent(Main.roll(this.name));

        int dmg = CalcChoice(pAction) + AttackModifer();
        if (isCombat){
            if(e.gotHit(EDodge,PlayerRoll)) {
                AttackEnemy(e,dmg,actionName);
                checkAlive(e,actionName);

            }
            else{
                dodged(e,pAction);
            }

        }










    }

    @Override
    public String toString() {
        return "Hero [name=" + name + ", health=" + health + ", dodge=" + dodge +", armor ="+armor+ ", attack=" +  attack + "]";
    }

    public int posDmg(){
        return 0;
    }




}

    


