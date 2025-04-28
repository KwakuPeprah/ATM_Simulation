import java.util.Scanner;// importing Scanner class for user input

//This is a simple ATM simulation program in Java

public class Swift_Banking_ATM {
    //Declare static variables for account balance and PIN
    private static double accountBalance = 100000.00;
    private static final int PIN = 1234; // the final keyword here means the PIN cannot be changed afte it is initialized
    public static boolean isRunning = true; 

    //Main method to run the ATM simulation
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Swift Banking");

        //Prompt user for PIN
        System.out.print("Please enter your PIN: ");
        int enteredPin = scanner.nextInt();

        //Authenticate user
        if (enteredPin != PIN) {
            System.out.println("Incorrect PIN. Please try again.");
            return; 
        }
        

        //Main menu options loop
        while (isRunning) {
            System.out.println("\nTransaction Menu:");
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdrawal");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt(); // Get user's choice

            switch (choice) {
                case 1:
                     balanceEnquiry();
                     break;
                case 2:
                     depositMoney(scanner);
                     break;
                case 3:
                        withdrawal(scanner);
                        break;
                case 4:
                    System.out.println("Thank you for using Swift Banking. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void balanceEnquiry() {
        System.out.printf("Your account balance is: $%.2f\n ", accountBalance);
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter an amount to deposit: ");
        double depositAmount = scanner.nextDouble();

        if (depositAmount > 0){
            accountBalance += depositAmount;
            System.out.printf("You have deposited $%.2f into your account. Your current balance is: $%.2f\n,", depositAmount, accountBalance);
        } else {
            System.out.println("Invalid amount. Please enter an amount more than zero (0)");
        }
    }

    private static void withdrawal(Scanner scanner) {
        System.out.print("Enter an amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();

        if (withdrawAmount > 0 && withdrawAmount <= accountBalance) {
            System.out.printf("You have succesfully withdrawn $%.2f. Your new balance is: $%.2f", withdrawAmount, accountBalance );
        }else {
            System.out.println("Invalid amount. Please enter a positve value");
        }
    }
}