//imports
import java.util.Scanner;

public class Main {
    //main
    public static void main(String[] args) {
        //impulmenting the scanner
        Scanner scan = new Scanner(System.in);

        //var for later in the game
        int oldMoney = 1000;

        while(true){
            System.out.println("Welcome to Roulette\n" +
                    "1. Play\n" +
                    "2. How to play\n" +
                    "3. Exit");
            try{
                int choice = scan.nextInt();
                switch(choice) {
                    case 1:
                        int holder = oldMoney;
                        while(true){
                            //if you start off with 0 money
                            if(oldMoney <= 0){
                                System.out.println("You don\'t have enough money to play\n" +
                                        "Goodbye");
                                break;
                            }

                            //playing the game
                            int money = roulette(oldMoney);
                            oldMoney = money;

                            //checking if you are not at $0
                            if(oldMoney <= 0){
                                System.out.println("You don\'t have enough money to continue playing\n" +
                                        "Goodbye");
                                break;
                            }

                            //asking if the player wants to play again
                            System.out.println("Do you want to play again?(y/n)");
                            String chosen = scan.next();

                            //user does not want to play anymore
                            if(!chosen.equalsIgnoreCase("y")){
                                System.out.println("You enter with $" + holder +
                                        "\n You are leaving with $" + oldMoney);
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("The rules are simple\n" +
                                "Bet some money and select where you betting the ball will land on\n" +
                                "If the ball landed on your section you win\n" +
                                "this is all about chance so good luck");
                        pressEnter();
                        break;
                    case 3:
                        System.out.println("Leaving the game");
                        System.exit(0);
                    default:
                        System.out.println("Please enter a valid number from 1 - 3");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Please enter a valid number");
                String throwAway = scan.next();
            }
        }
    }

    //functions
    //asking the player to press enter so the program can continue
    public static void pressEnter(){
        //scanner
        Scanner enter = new Scanner(System.in);

        //telling the player to press enter
        System.out.println("Please press enter to continue");
        String press = enter.nextLine();
    }

    //roulette
    public static int roulette(int money){
        //calling the compnets
        roulette_compnets compnets = new roulette_compnets(money);

        //user is betting there money
        compnets.betting();

        //user selection
        String userSelected = compnets.section();

        //the number that the user got form the ball
        int chosenNumber = compnets.table();

        //checking if the user won
        int amount = compnets.didWin(userSelected,chosenNumber);

        return amount;
    }
}