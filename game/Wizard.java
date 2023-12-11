package game;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import static game.Main.waveCount;

class Wizard extends Hero {
    static String[] spells = {"FireBall", "StormCloud", "Self-Heal"};
    private int stormCloudRounds = 0;

    static int stormCloudDamage = 0;

    boolean cloud= false;


    // Constructor for Wizard with additional parameters
    public Wizard(String name) {
        // Call the superclass constructor
        super(name);
        this.health = genHealth();
        this.dodge = genDodge();
        this.armor = genArmor();
        this.attack = super.genAttack();  // Default attack



        // Initialize the Wizard-specific variable
    }
    @Override
    public String ConvertAction(String action){
        int intValue = Integer.parseInt(action);
        return spells[intValue-1];
    }

    public boolean isCombat(String choice){
        return choice.equals("1") || choice.equals("2");
    }
    public int FireBall(){
        Random rand = new Random();
        int sum = 0;
        for(int i =0; i <5;i++){
            sum += rand.nextInt(1,4);
        }
        return  sum;
    }

    public int StormCloud(String choice) {
        if (cloud && !choice.equals("2")) {
            // The storm cloud is already active, apply damage for the current round
            int baseDamage = 5;  // Adjust the base damage as needed
            int totalDamage = baseDamage + waveCount;
            System.out.println(name + "'s storm cloud deals " + totalDamage + " damage in round " + waveCount + "!");
            stormCloudRounds--;

            // Optionally, you might want to do something else related to the storm cloud here

            return totalDamage;
        }
        if (choice.equals("2") && !cloud){
            cloud = true;
            // The storm cloud is summoned for the first time
            System.out.println(name + " summons a storm cloud that will last for multiple rounds!");
            stormCloudRounds = 3;  // Adjust the number of rounds as needed
            return 0;  // Returning 0 for the first round, or you can return an initial damage value if desired
        }
        if(choice.equals("2")){
            System.out.println("You cannot summon multiple clouds at once!");
            return -1;
        }

        return 0;
    }

    public  int SelfHeal(){
        Random rand = new Random();
        int sum = 0;
        for(int i =0; i <3;i++){
            sum += rand.nextInt(2,4);
        }
        setHealth(getHealth()+sum);
        System.out.println(this.name + " has cast self heal and has been granted " + sum + " health");
        displayHealth();
        return 0;
    }




    public int CalcChoice(String choice) {
        stormCloudDamage = StormCloud(choice);
        int rval = 0;
        if (choice.equals("2") && !cloud) {
            stormCloudDamage = StormCloud(choice);}

        if (stormCloudDamage == -1){
            choice = ChooseEitherClass();

        }

        if (choice.equals("1")) {
            rval = FireBall();
        // Update stormCloudDamage
        } else if (choice.equals("3")) {
            rval = SelfHeal();
        }

        return rval + stormCloudDamage;
    }


    public String ChooseClassAction(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose what Spell to cast:[1]FireBall, [2]StormCloud or [3]SelfHeal:");
        String choice = scanner.nextLine();
        while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3")){
            System.out.print("Choose what Spell to cast: [1]FireBall, [2]StormCloud or [3]SelfHeal:");
            choice = scanner.nextLine();
        }

        return choice;


    }
    public String ChooseEitherClass(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose what Spell to cast:[1]FireBall or [3]SelfHeal:");
        String choice = scanner.nextLine();
        while(!choice.equals("1") && !choice.equals("3")){
            System.out.print("Choose what Spell to cast: [1]FireBall or [3]SelfHeal:");
            choice = scanner.nextLine();
        }

        return choice;


    }

    public int genHealth(){
        Random rand = new Random();
        return  rand.nextInt(80,100);
    }
    public int genDodge(){
        Random rand = new Random();
        return  rand.nextInt(8,12);

    }
    public int genArmor(){
        Random rand = new Random();
        return  rand.nextInt(12,19);
    }


}




