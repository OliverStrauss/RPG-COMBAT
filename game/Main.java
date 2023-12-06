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
        System.out.print("Choose the name of your Hero");
        
        String choice = scanner.nextLine();
        
        return choice;
    }
    private static int genStat(String stat){
        Random random = new Random();
        int randomNumber = random.nextInt(6);
        int randomNumber1 = random.nextInt(6);
        int randomNumber2 = random.nextInt(6);
        int randomNumber3 = random.nextInt(6);

        int[]rolls = {randomNumber,randomNumber1,randomNumber2,randomNumber3};
        int min = rolls[0];
        for (int i = 1; i < rolls.length; i++) {
            if (rolls[i] < min) {
                min = rolls[i];
            }
        }

        // Compute the sum of elements excluding the smallest number
        int sum = 0;
        for (int num : rolls) {
            if (num != min) {
                sum += num;
            }
        }
        System.out.println("Your"+stat+"is"+sum);
        return sum;

    }


    public static void main(String[] args) {
        String[] heros = {"Wizard","Barb","Ranger"};
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        // Call the method to get user input
        String Hname = chooseName(scanner1);
        String Hclass = chooseClass(scanner);
        System.out.println("Welcome"+Hname+"our newest"+Hclass + "We will now roll for your stats ");
        int health = genStat("Health");
        int attack = genStat("Attack");
        int dodge = genStat("Dodge");

        if(Hclass.equals(heros[0])){
            Wizard w = new Wizard(Hname,health,attack,dodge);
            System.out.println(w);

        }

        scanner.close();
        scanner1.close();

        
    }

    // Method to get user input
}
