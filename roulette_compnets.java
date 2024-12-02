//imports
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class roulette_compnets {
    //private vars
    private int money;
    private int amount;

    //private int array list
    private ArrayList<Integer> Red = new ArrayList<Integer>();
    private ArrayList<Integer> Black = new ArrayList<Integer>();


    //scanner
    Scanner scan = new Scanner(System.in);

    //construtors
    //custom
    public roulette_compnets(int money){
        setMoney(money);
        addRed();
        addBlack();
    }

    //defult
    public roulette_compnets(){
        this(1000);
    }

    //setter
    public void setMoney(int money) {
        if(money <= 0){
            money = 1000;
        }
        this.money = money;
    }

    //setting the amount of money that will be betted
    public void setAmount(int amount) {
        if(amount <= 0){
            amount = money; //we are being petty and making the player bet all his money if they set there bet at 0 or lower
        }
        this.amount = amount;
    }

    private void addRed(){
        Red.add(1);
        Red.add(3);
        Red.add(5);
        Red.add(7);
        Red.add(9);
        Red.add(12);
        Red.add(14);
        Red.add(16);
        Red.add(18);
        Red.add(19);
        Red.add(21);
        Red.add(23);
        Red.add(25);
        Red.add(27);
        Red.add(30);
        Red.add(32);
        Red.add(34);
        Red.add(36);
    }

    private void addBlack(){
        Black.add(2);
        Black.add(4);
        Black.add(6);
        Black.add(8);
        Black.add(10);
        Black.add(11);
        Black.add(13);
        Black.add(15);
        Black.add(17);
        Black.add(20);
        Black.add(22);
        Black.add(24);
        Black.add(26);
        Black.add(29);
        Black.add(28);
        Black.add(31);
        Black.add(33);
        Black.add(35);
    }

    //getters
    public int getMoney() {
        return money;
    }

    public int getAmount() {
        return amount;
    }

    //componets
    //asking the player how much they are going to bet
    public void betting(){
        while(true) {
            System.out.println("You have $"+ money + "\n" +
                    "How much do you want to bet?");
            try{
                int amount = scan.nextInt();
                if(amount > this.money){
                    System.out.println("You don\'t have that much money");
                    continue;
                }
                setAmount(amount);
                break;
            }
            catch (Exception e){
                System.out.println("Please enter a valid number");
                String expect = scan.next();
            }
        }
    }

    //asking the player what they section they are betting on
    public String section(){
        while(true){
            //asking the user
            System.out.println("What is your selection?\n" +
                    "1. Red\n" +
                    "2. Black\n" +
                    "3. Even\n" +
                    "4. Odd\n" +
                    "5. 1 to 18\n" +
                    "6. 19 to 36\n" +
                    "7. 1st 12\n" +
                    "8. 2nd 12\n" +
                    "9. 3rd 12\n" +
                    "10. Specific Number");
            try{
                int choice = scan.nextInt();
                //checking on the users option
                switch (choice){
                    case 1:
                        return "Red";
                    case 2:
                        return "Black";
                    case 3:
                        return "Even";
                    case 4:
                        return "Odd";
                    case 5:
                        return "1 to 18";
                    case 6:
                        return "19 to 36";
                    case 7:
                        return "1st 12";
                    case 8:
                        return "2nd 12";
                    case 9:
                        return "3rd 12";
                    case 10:
                        while(true){
                            System.out.println("Please enter a number from 0 - 36");
                            //checking if your number is a number
                            try{
                                choice = scan.nextInt();

                                //if your number is not in between 0 - 36
                                if(choice >= 0 && choice <= 36){
                                    String num = Integer.toString(choice);
                                    return num;
                                }
                                System.out.println("That\'s not a valid number.\n" +
                                        "Please enter a number between 0 - 36");
                            }
                            catch (Exception e){
                                System.out.println("Please enter a valid number");
                                String expstion = scan.next();
                            }
                        }


                    default: //if the user did not select a input of 1 - 9
                        System.out.println("Please enter a valid number from 1 - 9");
                }
            }
            //user input a String or a Char instead of a int
            catch (Exception e){
                System.out.println("Please enter a valid number");
                String extension = scan.next();
            }
        }
    }

    //loop for when the "ball" reachs its destanation
    public int table(){
        int ball = 0;
        ArrayList<Integer> endPoint = new ArrayList<Integer>();

        //random
        Random rand = new Random();

        //where the ball will stop
        int ballEnd = rand.nextInt(0,36);

        //spinning the ball to its destantaon
        System.out.println("SPINNING THE WHEEL!!!!");

        //loop where it build suspance
        for(int i = 0; i <= 73; i++){
            int j = i;

            //checking if i is 30 or greater
            if(i > 36){
                j -= 37;
            }

            System.out.println(j);

            //2 second timmer that I stole from chatgpt
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //loop for where the ball will land
        for(int i = 0; i <= ballEnd; i++){
            endPoint.add(i); //making it look "pretty" that there is a type of spin
            System.out.println(endPoint.get(endPoint.size() - 1));
            ball = i;

            //timmer to build suspince
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //returns where the ball ends
        return ball;
    }

    public int didWin(String bet, int num){
        if(bet.equals("Red")){
            if(Red.contains(num))
            {
                System.out.println("You got lucky today, you won $" + amount);
                money += amount;
            }
            else{
                System.out.println("You sadly lost $" + amount);
                money -= amount;
            }
        }
        else if(bet.equals("Black")){
            if(Black.contains(num))
            {
                System.out.println("You got lucky today, you won $" + amount);
                money += amount;
            }
            else{
                System.out.println("You sadly lost $" + amount);
                money -= amount;
            }
        }
        else if(bet.equals("Even")){
            if(num % 2 == 0){
                System.out.println("You got lucky today, you won $" + amount);
                money += amount;
            }
            else{
                System.out.println("You sadly lost $" + amount);
                money -= amount;
            }
        }
        else if(bet.equals("Odd")){
            if(num % 2 == 1){
                System.out.println("You got lucky today, you won $" + amount);
                money += amount;
            }
            else{
                System.out.println("You sadly lost $" + amount);
                money -= amount;
            }
        }
        else if(bet.equals("1 to 18")){
            if(num >= 1 && num <= 18){
                System.out.println("You got lucky today, you won $" + amount);
                money += amount;
            }
            else{
                System.out.println("You sadly lost $" + amount);
                money -= amount;
            }
        }
        else if(bet.equals("19 to 36")){
            if(num >= 19 && num <= 36){
                System.out.println("You got lucky today, you won $" + amount);
                money += amount;
            }
            else{
                System.out.println("You sadly lost $" + amount);
                money -= amount;
            }
        }
        else if(bet.equals("1st 12")){
            if(num >= 1 && num <= 12){
                System.out.println("You got lucky today, you won $" + amount);
                money += amount;
            }
            else{
                System.out.println("You sadly lost $" + amount);
                money -= amount;
            }
        }
        else if(bet.equals("2nd 12")){
            if(num >= 13 && num <= 24){
                System.out.println("You got lucky today, you won $" + amount);
                money += amount;
            }
            else{
                System.out.println("You sadly lost $" + amount);
                money -= amount;
            }
        }
        else if(bet.equals("3rd 12")){
            if(num >= 25 && num <= 36){
                System.out.println("You got lucky today, you won $" + amount);
                money += amount;
            }
            else{
                System.out.println("You sadly lost $" + amount);
                money -= amount;
            }
        }
        else{
            if(bet.equals(Integer.toString(num))){
                System.out.println("You got lucky today, you won $" + amount);
                money += amount;
            }
            else{
                System.out.println("You sadly lost $" + amount);
                money -= amount;
            }
        }
        return money;
    }
}
