package game;
import java.util.Scanner;
import java.util.Random;


public class Main {



    private static String chooseClass(Scanner scanner) {
        // Prompt the user for input\
        System.out.print("Choose what class of Hero you would like to be: Barbarian, Wizard or Ranger:");
        String choice = scanner.nextLine();
        while(!choice.equals("Wizard") && !choice.equals("Barbarian") && !choice.equals("Ranger")){
            System.out.print("Choose what class of Hero you would like to be: Barbarian, Wizard or Ranger:");
            choice = scanner.nextLine();
        }

        // Read the user input
        return choice;
    }
    private static String chooseName(Scanner scanner) {
        // Prompt the user for input\        
        System.out.print("Choose the name of your Hero ");
        
        return scanner.nextLine();
    }

    public static void pauseGame(int delay) {
        try {
            // Sleep for 1000 milliseconds (1 second)
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            // Handle InterruptedException if necessary
            e.printStackTrace();
        }

            // Wait for the user to press Enter

    }
    public static int roll(String name){
        Random rand = new Random();
        int val =  rand.nextInt(0,20);
        System.out.println(name + " has rolled a " + val);
        return val;
    }

    public static double RollToPercent(int roll){
        return (roll*5.0)/100;

    }

    public static int waveCount =1;
    public static void main(String[] args) {
        String[] heroes = {"Wizard","Barbarian","Ranger"};
        String [] stats = {"Health","Dodge","Armor","Dodge"};
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        // Call the method to get user input
        String Hname = chooseName(scanner1);
        String Hclass = chooseClass(scanner);
        System.out.println("Welcome "+Hname+" our newest "+Hclass + " We will now roll for your stats ");

        if(Hclass.equals(heroes[0])){
            Wizard hero = new Wizard(Hname);
        }
        Wizard hero = new Wizard(Hname);


        pauseGame(1000);
        System.out.println(hero);
        while(waveCount < 7){
            System.out.println("Entering wave "+waveCount);
            pauseGame(1000);
            Enemy e = new Skeleton();
            //System.out.println(e);

            hero.PlayerTurn(e);
            System.out.println(e);
            pauseGame(2000);
            e.AttackHero(hero);
            System.out.println(hero);


            waveCount +=1;
        }

        scanner.close();
        scanner1.close();

        
    }

    // Method to get user input
}
