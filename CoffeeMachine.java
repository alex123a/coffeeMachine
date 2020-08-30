import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int waterLeft = 400;
        int milkLeft = 540;
        int coffeeLeft = 120;
        int cupsLeft = 9;
        int money = 550;
        
        boolean running = true;
        while (running) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            
            if (action.contains("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:" );
                String typeCoffee = scanner.next();
                boolean enough = false;
                switch(typeCoffee) {
                    case "1":
                        enough = enoughCoffee(waterLeft, milkLeft, coffeeLeft, cupsLeft, typeCoffee);
                        if (enough == true) {
                            System.out.println("I have enough resources, making you a coffee!");
                            waterLeft -= 250;
                            coffeeLeft -= 16;
                            cupsLeft -= 1;
                            money += 4;
                        } else {
                            neededItems(waterLeft, coffeeLeft, cupsLeft, milkLeft);
                        }
                        break;
                    case "2":
                        enough = enoughCoffee(waterLeft, milkLeft, coffeeLeft, cupsLeft, typeCoffee);
                        if (enough == true) {
                            System.out.println("I have enough resources, making you a coffee!");
                            waterLeft -= 350;
                            milkLeft -= 75;
                            coffeeLeft -= 20;
                            cupsLeft -= 1;
                            money += 7;
                        } else {
                            neededItems(waterLeft, coffeeLeft, cupsLeft, milkLeft);
                        }
                        break;
                    case "3":
                        enough = enoughCoffee(waterLeft, milkLeft, coffeeLeft, cupsLeft, typeCoffee);
                        if (enough == true) {
                            System.out.println("I have enough resources, making you a coffee!");
                            waterLeft -= 200;
                            milkLeft -= 100;
                            coffeeLeft -= 12;
                            cupsLeft -= 1;
                            money += 6;
                        } else {
                            neededItems(waterLeft, coffeeLeft, cupsLeft, milkLeft);
                        }
                        break;
                    default:
                        break;
                }
                continue;
            } else if (action.contains("fill")) {
                System.out.println("Write how many ml of water do you want to add: ");
                int waterAdd = scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                int milkAdd = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                int coffeeAdd = scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int cupsAdd = scanner.nextInt();

                waterLeft += waterAdd;
                milkLeft += milkAdd;
                coffeeLeft += coffeeAdd;
                cupsLeft += cupsAdd;
            } else if (action.contains("take")) {
                System.out.println("I gave you $" + money);
                money -= money;
            } else if (action.contains("remaining")) {
                status(waterLeft, milkLeft, coffeeLeft, cupsLeft, money);
            } else if (action.contains("exit")) {
                running = false; 
            } else {
                System.out.println("Unknown action");
            }
        }
        
    }
    
    public static void status(int waterLeft, int milkLeft, int coffeeLeft, int cupsLeft, int money) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(waterLeft + " of water");
        System.out.println(milkLeft + " of milk");
        System.out.println(coffeeLeft + " of coffee beans");
        System.out.println(cupsLeft + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void neededItems(int waterLeft, int milkLeft, int coffeeLeft, int cupsLeft) {
        System.out.println("Not enough resources! Use 'fill' to stock up more recourses");
    }

    public static boolean enoughCoffee(int waterLeft, int milkLeft, int coffeeLeft, int cupsLeft, String typeCoffee) {
        int waterOneCup = 0;
        int coffeeOneCup = 0;
        int milkOneCup = 0;
        int cups = 1;
        boolean accepted = false;
        switch(typeCoffee) {
            case "1":
                waterOneCup = 250;
                coffeeOneCup = 16;
                if (waterLeft >= waterOneCup && cups > 0 && coffeeLeft >= coffeeOneCup) {
                    accepted = true;
                } else {
                    accepted = false;
                }
            case "2":
                waterOneCup = 350;
                milkOneCup = 75;
                coffeeOneCup = 20;
                if (waterLeft >= waterOneCup && cups > 0 && coffeeLeft >= coffeeOneCup && milkLeft >= milkOneCup) {
                    accepted = true;
                } else {
                    accepted = false;
                }
            case "3":
                waterOneCup = 200;
                milkOneCup = 100;
                coffeeOneCup = 12;
                if (waterLeft >= waterOneCup && cups > 0 && coffeeLeft >= coffeeOneCup && milkLeft >= milkOneCup) {
                    accepted = true;
                } else {
                    accepted = false;
                }
        }
        if (accepted == true) {
            return true;
        } else {
            return false;
        }
    }
}
